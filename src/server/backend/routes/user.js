var express = require('express');
var router = express.Router();
const db = require('../db');
const userContrller = require('../controllers/userController');
/* GET users listing. */

router.get('/', userContrller.list );
router.get('/:name', userContrller.show);
router.post('/', userContrller.create);
router.put('/:id', userContrller.update);
router.delete('/:id', userContrller.remove);


module.exports = router;

