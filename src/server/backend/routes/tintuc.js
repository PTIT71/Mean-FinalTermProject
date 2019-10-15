var express = require('express');
var router = express.Router();
const tintucContrller = require('../controllers/tintucController');
/* GET users listing. */

router.get('/', tintucContrller.list );
router.post('/', tintucContrller.create);
router.put('/:id', tintucContrller.update);
router.delete('/:id', tintucContrller.remove);


module.exports = router;