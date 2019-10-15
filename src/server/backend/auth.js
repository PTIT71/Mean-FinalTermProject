var Passport = require('passport')
const LocalStrategy = require('passport-local').Strategy;
var uModel = require('./models/userModel')
var md5 = require('md5');

Passport.use(new LocalStrategy({
    usernameField: 'name',
    passwordField: 'pass',
  },
    function(name, pass, done) {
      var query = {name:name}
      console.log(name);
      
      uModel.findOne(query, function (err, user) {
        console.log(user);
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
  
  Passport.serializeUser((user,done)=>{
    done(null,user)
  })
  
  Passport.deserializeUser((name,done)=>{
    uModel.findOne({ name: name }, function (err, user) {
      if (err) { return done(err); }
      if (user) {
        return done(null, user);
      }else{
        return done(null,false);
      }
    });
  })

module.exports= Passport