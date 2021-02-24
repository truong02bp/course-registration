let mysql = require("mysql");
let config = {
  host: "",
  user: "",
  password: "",
  database: "web",
};
let connection = mysql.createConnection(config);

// insert statment
let sql = `insert into web.room values (10, '2020-10-14 11:25:13', 'admin', '2020-10-14 11:25:13', 'admin', 'asa');`;

// execute the insert statment
connection.query(sql, (err, results, fields) => {
  if (err) {
    return console.error(err.message);
  }
  // get inserted id
  console.log("end", results);
});

connection.end();
