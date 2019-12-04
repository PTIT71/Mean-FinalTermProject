var spModel = require('../models/sanphamModel');
 

module.exports = {
 
  
    list: function(req, res) {
        spModel.find(function(err, cars){
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
        spModel.findOne({name: name}, function(err, car){
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
        var sp = new spModel({          
            name : req.body.name,
            cost : parseInt(req.body.cost),
            idGear : req.body.idGear,
            idKind : req.body.idKind,
            count : parseInt(req.body.count),
            image : req.body.image,  
        });
        
        sp.save(function(err, sp){
            if(err) {
                return res.status(500).json({
                    message: 'Error saving sp',
                    error: err
                });
            }
            return res.json({
                message: 'saved',
                name: sp.name
            });
        });
    },
 
 
    update: function(req, res) {
        var id = req.params.id;
        spModel.findOne({_id: id}, function(err, sp){
            if(err) {
                return res.status(500).json({
                    message: 'Error saving sp',
                    error: err
                });
            }
            if(!sp) {
                return res.status(404).json({
                    message: 'No such sp'
                });
            }
 
          
            sp.name = req.body.name ? req.body.name : sp.name;
            sp.count = parseInt(req.body.count) ? parseInt(req.body.count) : sp.count;
            sp.idGear = req.body.idGear ? req.body.idGear : sp.idGear;
            sp.idKind = req.body.idKind ? req.body.idKind : sp.idKind;
            sp.count = parseInt(req.body.count) ? parseInt(req.body.count) : sp.count;
            sp.name = req.body.name ? req.body.name : sp.name;

            sp.save(function(err, car){
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
        });
    },
 
   
    remove: function(req, res) {
        var id = req.params.id;
        spModel.findByIdAndRemove(id, function(err, car){
            if(err) {
                return res.status(500).json({
                    message: 'Error getting car.'
                });
            }
            return res.json(car);
        });
    }
};