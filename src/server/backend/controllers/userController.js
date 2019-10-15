var uModel = require('../models/userModel');
var md5 = require('md5');

module.exports = {
 
  
    list: function(req, res) {
        uModel.find(function(err, cars){
            if(err) {
                return res.status(500).json({
                    message: 'Error getting sp.'
                });
            }
            return res.json(cars);
        });
    },
 

    show: function(req, res) {
        var name = req.params.name;
        uModel.findOne({name: name}, function(err, car){
            if(err) {
                return res.status(500).json({
                    message: 'Error getting sp.'
                });
            }
            if(!car) {
                return res.status(404).json({
                    message: 'No such sp'
                });
            }
            return res.json(car);
        });
    },
 
 
    create: function(req, res) {
        var user = new uModel({          
            name : req.body.name,
            mail : req.body.mail,
            pass : md5(req.body.pass),
        });
        
        user.save(function(err, result){
            if(err) {
                return res.status(500).json({
                    message: 'Error saving sp',
                    error: err
                });
            }
            return res.json({
                message: 'saved',
                name: result.name
            });
        });
    },
 
 
    update: function(req, res) {
        var id = req.params.id;
        uModel.findOne({_id: id}, function(err, result){
            if(err) {
                return res.status(500).json({
                    message: 'Error saving sp',
                    error: err
                });
            }
            if(!result) {
                return res.status(404).json({
                    message: 'No such sp'
                });
            }
 
          
            result.name = req.body.name ? req.body.name : result.name;
            result.mail = req.body.mail ? req.body.mail : result.mail;
            result.pass = md5(req.body.pass) ? md5(req.body.pass) : result.pass;


            result.save(function(err, car){
                if(err) {
                    return res.status(500).json({
                        message: 'Error getting user.'
                    });
                }
                if(!car) {
                    return res.status(404).json({
                        message: 'No such user'
                    });
                }
                return res.json(car);
            });
        });
    },
 
   
    remove: function(req, res) {
        var id = req.params.id;
        uModel.findByIdAndRemove(id, function(err, car){
            if(err) {
                return res.status(500).json({
                    message: 'Error getting user.'
                });
            }
            return res.json(car);
        });
    }
};