var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/page/:page', function(req, res, next) {
  res.send("aa");
});

module.exports = router;
