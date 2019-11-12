var Passport = require('passport')
const LocalStrategy = require('passport-local').Strategy;
var GoogleStrategy = require('passport-google-oauth').OAuth2Strategy;
var uModel = require('./models/userModel')
var md5 = require('md5');
const configAuth = require('./config/auth');

Passport.use(new LocalStrategy({
    usernameField: 'name',
    passwordField: 'pass',
  },
    function(name, pass, done) {
      var query = {name:name}
      
      uModel.findOne(query, function (err, user) {
        if (err) { return done(err); }
        if (!user) {
          return done(null, false, { message: 'Incorrect username.' });
        }
        if (user.pass !== md5(pass)) {
          return done(null, false, { message: 'Incorrect password.' });
        }
        return done(null, user);
      });
    }
  ));
  
  Passport.deserializeUser((mail,done)=>{
    uModel.findOne({ mail: mail }, function (err, user) {
      if (err) { 
        return done(err); }
      if (user) {
        return done(null, user);
      }else{
        return done(null,false);
      }
    });
  })

  Passport.serializeUser((user,done)=>{
    console.log("serializeUser " + JSON.stringify(user));
    done(null,user.mail)
  })

  Passport.use(new GoogleStrategy({
    clientID: configAuth.googleAuth.clientID,
    clientSecret: configAuth.googleAuth.clientSecret,
    callbackURL: configAuth.googleAuth.callbackURL
  },
  function(accessToken, refreshToken, profile, done) {
      process.nextTick(function(){
        uModel.findOne({'google.id': profile.id}, function(err, user){
          if(err)
            return done(err);
          if(user)
            return done(null, user);
          else {
            var newUser = new uModel();
            newUser.google.id = profile.id;
            newUser.google.token = accessToken;
            newUser.google.name = profile.displayName;
            newUser.mail = profile.emails[0].value;
            newUser.save(function(err){
              if(err)
                throw err;
              return done(null, newUser);
            })
          }
        });
      });
    }

));

module.exports= Passport