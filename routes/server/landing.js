module.exports = function(router){
/* GET home page. */
router.get('/', function(req, res) {
    console.log("welcome")
  res.render('timesheet', { title: 'TIMESHEET REMINDER POC' });
});
}
