var mongoose = require('mongoose');
var Schema   = mongoose.Schema;

var Kind = new Schema({
    "idKind" : Number,
    "name" : String,  
});

module.exports = mongoose.model('Kind', Kind, "Kind");