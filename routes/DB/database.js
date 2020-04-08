var fs = require("fs");

module.exports = {
  create: function (name) {
    try {
      var path = __dirname + "/base/";
      console.log(path);
      if (!fs.existsSync(path)) {
        fs.mkdirSync(path);
      }
      var content = {[name]:[]};
      fs.access(path + name + ".json", (err) => {
        if (!err) {
          console.log("Table already exsits");
        } else {
          fs.writeFile(
            path + name + ".json",
            JSON.stringify(content),
            function (err, file) {
              if (err) throw err;
              console.log("created");
            }
          );
        }
      });
    } catch (e) {
      console.log(e);
    }
  },

  insert: function (table, data) {
    try {
      var path = __dirname + "/base/";
      if (!fs.existsSync(path)) {
        console.log("Create the Table to Insert");
      }
      fs.access(path + table + ".json", (err) => {
        if (err) {
          console.log("Create a table to Intert");
        } else {
          console.log("inside write",JSON.parse(data))
          var rawcontent = fs.readFileSync(path + table + ".json");
          var content = JSON.parse(rawcontent);
          console.log(rawcontent+"  asd     "+content)
          content[table].push(JSON.parse(data));
          fs.writeFile(
            path + table + ".json",
            JSON.stringify(content),
            (err, file) => {
              if (err) throw err;
              console.log("Table Updated");
            }
          );
        }
      });
    } catch (e) {
      console.log(e);
    }
  },

  find: (table, key, value,callback) => {
    var keyVal;
    var ret;
    try {
      var path = __dirname + "/base/";
      if (!fs.existsSync(path)) {
        console.log("Create the Table to Perform Action");
      }
      fs.access(path + table + ".json", (err) => {
        if (err) {
          console.log("Table not Found");
        } else {
          var rawcontent = fs.readFileSync(path + table + ".json");
          var content = JSON.parse(rawcontent);
          for (var i = 0; i < content.length; i++) {
            console.log(content[i][key] + "       " + value);
            if (content[i][key] === value) {
              keyVal = content[i];
            }
          }
          if (keyVal != undefined && keyVal != null) {
            ret = keyVal;
          } else {
            console.log("Record not found");
            ret = "null";
          }
          callback(ret);
        }
      });      
    } catch (e) {
      console.log(e);
    }
  },

  drop : (table)=>{
try{
  var file = __dirname + "/base/"+table+".json"
fs.unlinkSync(file)
console.log("deleted")
//return "Successfully Deleted"
}
catch(e){
    console.log(e)
}
  }
};
