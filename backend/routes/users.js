var express = require('express');
var mysql = require('mysql');
var userService = require('../service/userService');
var router = express.Router();


var connection = mysql.createConnection({
  host     : '192.168.3.18',
  user     : 'stock',
  password : 'stock',
  database : 'stock'
  });

connection.connect();

/* GET users listing. */
router.get('/', function(req, res, next) {
  userService.findByPage(1,10)
  .then(function(data){
    res.send(data);
  });
  
});

router.get('/page/:page',function(req,res,next){
  let pageSize=2;
  let page = req.params.page;
  userService.findByPage(page,pageSize)
  .then(function(data){
    res.send(data);
  });
});

router.post('/',function(req,res,next){

  console.log(req.body);
  let param = [req.body.name];
  connection.query("insert into user (name) values (?)",param,function (err, result) {
    if(err){
      console.log('[INSERT ERROR] - ',err.message);
      return;
    }    
    res.send("success"); 
  });
});

router.put('/id/:id',function(req,res,next){
  console.log(req.params.id);
  let id = req.params.id;
  let set = {name: req.body.name};
  connection.query("update user set ? where id="+id,set,function(err,result){
    if(err){
      console.log('[INSERT ERROR] - ',err.message);
      return;
    }   
    res.send("success"); 
  });
});

module.exports = router;
