var mongoose = require('mongoose');
var Schema   = mongoose.Schema;

var SanPham = new Schema({
    "name" : String,
    "cost" : Number,
    "idGear" : String,
    "idKind" : String,
    "count" : Number,
    "image" : String,  
});

module.exports = mongoose.model('SanPham', SanPham, "SanPham");