var ttModel = require('../models/tintucModel');
 

module.exports = {
 
  
    list: function(req, res) {
        ttModel.find(function(err, tt){
            if(err) {
                return res.status(500).json({
                    message: 'Error getting sp.'
                });
            }
            return res.json(tt);
        });
    },
 

    // show: function(req, res) {
    //     var name = req.params.name;
    //     spModel.findOne({name: name}, function(err, car){
    //         if(err) {
    //             return res.status(500).json({
    //                 message: 'Error getting sp.'
    //             });
    //         }
    //         if(!car) {
    //             return res.status(404).json({
    //                 message: 'No such sp'
    //             });
    //         }
    //         return res.json(car);
    //     });
    // },
 
 
    create: function(req, res) {
        var tt = new ttModel({          
            title : req.body.title,
            content : req.body.content,
            image : req.body.image   
        });
        
        tt.save(function(err, sp){
            if(err) {
                return res.status(500).json({
                    message: 'Error saving sp',
                    error: err
                });
            }
            return res.json({
                message: 'saved',
                title: tt.title
            });
        });
    },
 
 
    update: function(req, res) {
        var id = req.params.id;
        spModel.findOne({_id: id}, function(err, tt){
            if(err) {
                return res.status(500).json({
                    message: 'Error saving sp',
                    error: err
                });
            }
            if(!tt) {
                return res.status(404).json({
                    message: 'No such sp'
                });
            }
 
          
            tt.title = req.body.title ? req.body.title : tt.title;
            tt.content = req.body.content ? req.body.content : tt.content;
            tt.image = req.body.image ? req.body.image : tt.image

            tt.save(function(err, car){
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
        ttModel.findByIdAndRemove(id, function(err, car){
            if(err) {
                return res.status(500).json({
                    message: 'Error getting car.'
                });
            }
            return res.json(car);
        });
    }
};