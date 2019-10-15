var express = require('express');
var router = express.Router();
var Passport = require('../auth');


router.get('/', function(req, res) {
  res.send("hãy mở postman post /login : {\"name\":\"thinh\",\"pass\":\"thinh\"}")
})

router.post('/', Passport.authenticate('local',{
                                      successRedirect : "/sanpham" , 
                                      failureRedirect : "/login" 
}));


module.exports = router;



