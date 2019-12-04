var mongoose = require('mongoose');
var Schema   = mongoose.Schema;

var TinTuc = new Schema({
    "title" : String,
    "content" : Number,
    "image" : String,  
});

module.exports = mongoose.model('TinTuc', TinTuc , "TinTuc");