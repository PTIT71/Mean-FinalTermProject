var express = require('express');
var path = require('path');
var favicon = require('static-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var session = require('express-session')
var Passport = require('./auth')
var sanpham = require('./routes/sanpham');
var user = require('./routes/user');
var login = require('./routes/login');
var tintuc = require('./routes/tintuc')
var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');
// passparse





app.use(favicon());
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended :true}));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use(session({
    secret: 'mesecret',
    cookie:{
        maxAge : 1000*60*5
    },
    resave: false,
    saveUninitialized: true
}));
app.use(Passport.initialize())
app.use(Passport.session())

var isAuthenticated = function (req, res, next) {
    if (req.isAuthenticated())
        return next();
    res.redirect('/login');
}

app.use('/sanpham',isAuthenticated, sanpham);
app.use('/user',isAuthenticated,user);
app.use('/login',login);
app.use('/tintuc',isAuthenticated,tintuc);


app.use(function(req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

/// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
    app.use(function(err, req, res, next) {
        res.status(err.status || 500);
        res.render('error', {
            message: err.message,
            error: err
        });
    });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
        message: err.message,
        error: {}
    });
});


module.exports = app;
