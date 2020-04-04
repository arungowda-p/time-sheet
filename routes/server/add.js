module.exports = function(router){
/* GET home page. */
router.post('/add/:emp', function(req, res) {
 console.log(req.body)
 res.send(200)
});
}
