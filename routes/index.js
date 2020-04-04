var fs = require('fs');
var express = require('express');
var router = express.Router();


var normalizedPath = require("path").join(__dirname+"/server");
console.log("welcome--------------------------------------")
require("fs").readdirSync(normalizedPath).forEach(function(file) {
  require("./server/"+file)(router);
});


module.exports = router;
