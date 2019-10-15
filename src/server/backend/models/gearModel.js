var mongoose = require('mongoose');
var Schema   = mongoose.Schema;

var Gear = new Schema({
    "idGear" : String,
    "color"  : String, 
});

module.exports = mongoose.model('Gear', Gear, "Gear");