var mongoose = require('mongoose');
var Schema   = mongoose.Schema;

var User = new Schema({
    "name" : String,
    "mail" : String,
    "pass" : String,
    "google": {
        "id": String,
        "token": String,
        "name": String
    }
});



module.exports = mongoose.model("User", User , "User");

