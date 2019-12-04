var mongoose = require('mongoose');
var Schema   = mongoose.Schema;

var FeedBack = new Schema({
    "name" : String,
    "image" : String,
    "feedback" : String  
});

module.exports = mongoose.model('Feedback', Feedback, "Feedback");