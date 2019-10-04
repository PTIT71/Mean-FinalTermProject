var path = require('path');
var express = require('express');
var serveStatic = require('serve-static');
var bodyParser = require("body-parser");
const app = express();
const db = require('./db');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// Này là test nên cứ để đi đừng xóa

// app.get('/getXe/:tenxe', (req, res)=>{
//     const nameXe = req.params.tenxe
//     var query = {name:nameXe}
//     db.getDB().collection("XeMay").find(query).toArray((err,result)=>{
//         if(err) throw err;
//         else {
//             console.log(result[0].name);
//             res.json(result);
//         }
//     })
// })
//===================================================================
//Khu vực code thêm dữ liệu "Cấm hỏi và đụng vô"

//Thêm Sản phâm :
app.post('/api/add/SanPham',function(req,res){
  var name =req.body.name;
  var cost =req.body.cost;
  var idGear = req.body.idGear;
  var idKind = req.body.idKind;
  var count = req.body.count;
  var image = req.body.image;
  var myobj = {name: name, cost: cost , idKind: idKind ,idGear:idGear, count:count, image:image};
  db.getDB().collection("SanPham").insertOne(myobj, function(err, res) {
    if (err) throw err;
    console.log("1 document inserted");
    console.log(res);
  });
});


//====================================================================
app.use(serveStatic(path.join(__dirname, 'public')));
var listUsers = [{ id: 1, name: 'Nguyễn Văn A' }, { id: 2, name: 'Hoàng Thị B' }, { id: 3, name: 'Phan Huy C' }];

app.get('/', function(req, res) {
    res.send('I am listening');
});

//load 1 trang có sẳn 
<<<<<<< HEAD
app.get('/home', function(request, response){
    response.redirect('../Angulars/src/view/user/index.html');
  });
=======
app.get('/home', function(request, response) {
    response.redirect('./src/view/user/index.html');
});
>>>>>>> cf92032cd05ec7e776fbf093fb53ae06ceb2061a


app.get('/api/getName/:userId', function(request, response) {
    var userId = request.params.userId;
    var user = listUsers.find(u => u.id == userId)
    if (user)
        response.send(user.name);
    else
        response.send('User not found!!!')
});

app.get('/api/getGiaXe/:tenxe', function(req, res) {
    var ten = req.params.tenxe;
    var query = { name: ten }
    db.getDB().collection("XeMay").find(query).toArray((err, result) => {
        if (err) throw err;
        else {
            var data = (result[0].cost).toString();
            res.status(200).send(data);
        }
    })
});


<<<<<<< HEAD
//load list danh sách sản phẩm
app.get('/api/getList/SanPham', function(req, res) {
    db.getDB().collection("SanPham").find().toArray((err, result) => {
        if (err) throw err;
        else {
            console.log(result);
            res.send(result);
        }
=======
  //load list danh sách sản phẩm
  //1001
  app.get('/api/getList/SanPham',function(req,res){
    db.getDB().collection("SanPham").find().toArray((err,result)=>{
      if(err) throw err;
      else {
        console.log(result);
        res.send(result);
      }
>>>>>>> 3003deb78c29e446d3324b5220d7b3a7dc7914fb
    })
})

<<<<<<< HEAD
    //load list danh sách tin tuc
  //1002
  app.get('/api/getList/TinTuc',function(req,res){
    db.getDB().collection("TinTuc").find().toArray((err,result)=>{
      if(err) throw err;
      else {
        console.log(result);
        res.send(result);
      }
    })
  })

    //load list danh sách feedback
  //1003
  app.get('/api/getList/Feedback',function(req,res){
    db.getDB().collection("SanPham").find().toArray((err,result)=>{
      if(err) throw err;
      else {
        console.log(result);
        res.send(result);
      }
    })
  })


db.connect((err)=>{
    if(err){
=======
db.connect((err) => {
    if (err) {
>>>>>>> cf92032cd05ec7e776fbf093fb53ae06ceb2061a
        console.log("Khong ket noi duoc database");
        process.exit();
    } else {
        app.listen(3000, () => {
            console.log('connected database , app lissten to 3000');
        })
    }
})