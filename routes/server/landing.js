module.exports = function(router){
/* GET home page. */
router.get('/', function(req, res) {
    console.log("welcome")
  res.render('timesheet', { title: 'TIMESHEET REMINDER POC' });
});
router.get('/face', function(req, res) {
    console.log("face")
  res.render('face/index', { title: 'TIMESHEET REMINDER POC' });
});
/*router.get('/face/:file', function(req, res) {
    console.log(req.params.file)
    var js=require("../../views/face/"+req.params.file)
  res.send(js);
});*/
}
