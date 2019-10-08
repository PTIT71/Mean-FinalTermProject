var express = require('express');
var router = express.Router();
const db = require('../db');
const sanphamContrller = require('../controllers/sanphamController');
/* GET users listing. */

router.get('/', sanphamContrller.list );
router.get('/:name', sanphamContrller.show);
router.post('/', sanphamContrller.create);
router.put('/:id', sanphamContrller.update);
router.delete('/:id', sanphamContrller.remove);


module.exports = router;

