var db = require('../DB/database')

module.exports = function(router){
/* GET home page. */
router.post('/add/:emp', function(req, res) {
 //console.log(req.body)
 //db.create('empe')
 //db.insert('empe', req.body)
 let data;
db.find('empe', 'id', '168188',(val) => {
   data = val;
   console.log(data+"uuuuuuuuuuuuuuuuuuu")
})
 setTimeout(() => {
    console.log(data+" 5524555")
    res.send(data)
 }, 500);
});
}
