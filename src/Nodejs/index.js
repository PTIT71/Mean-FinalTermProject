var path = require('path');
var express = require('express');
var serveStatic = require('serve-static');
const app = express();
const db = require('./db');


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



//====================================================================
app.use(serveStatic(path.join(__dirname, 'public')));
var listUsers = [{ id: 1, name: 'Nguyễn Văn A' }, { id: 2, name: 'Hoàng Thị B' }, { id: 3, name: 'Phan Huy C' }];

app.get('/', function(req, res) {
    res.send('I am listening');
});

//load 1 trang có sẳn 
app.get('/home', function(request, response) {
    response.redirect('./src/view/user/index.html');
});


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


//load list danh sách sản phẩm
app.get('/api/getList/SanPham', function(req, res) {
    db.getDB().collection("SanPham").find().toArray((err, result) => {
        if (err) throw err;
        else {
            console.log(result);
            res.send(result);
        }
    })
})

db.connect((err) => {
    if (err) {
        console.log("Khong ket noi duoc database");
        process.exit();
    } else {
        app.listen(3000, () => {
            console.log('connected database , app lissten to 3000');
        })
    }
})