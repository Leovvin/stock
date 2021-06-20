var mysql = require('mysql');


var connection = mysql.createConnection({
    host     : '192.168.3.18',
    user     : 'stock',
    password : 'stock',
    database : 'stock'
    })
connection.connect();

var userService = {};

userService.findByPage = function(page,pageSize){
    return new Promise(function(succ,fail){
        connection.query("select * from user limit "+(page-1)*pageSize+","+pageSize,function (err, result) {
            if(err){
              console.log('[SELECT ERROR] - ',err.message);
              return;
            } 
            let users = [];
            for(let i = 0;i<result.length;i++){
              users[i] = result[i];
            }
            succ(users);
          });
    });
}

module.exports=userService;