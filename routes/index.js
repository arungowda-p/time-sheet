var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/timesheet', function(req, res, next) {
  res.render('timesheet', { title: 'TIMESHEET REMINDER POC' });
});

module.exports = router;
