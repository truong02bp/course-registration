process.stdout.write("\033c");
const fs = require("fs");
const _ = require("lodash");
//import end

let listMH = fs.readdirSync("./json");
//loop all mh => all data
let allData = listMH.map((mh) => {
  let dataFile = fs.readFileSync(`./json/${mh}`);
  return JSON.parse(dataFile);
});
// console.log(allData.flat(3));
// get all professor
let professor = [];
let sp = allData[0][0][14][6];
// console.log(sp);
for (let i = 0; i < allData.length; i++) {
  let element = allData[i];
  for (let j = 0; j < element.length; j++) {
    let mh = element[j];
    // console.log(mh);
    // mh.map((item, index) => console.log(item, index));
    professor.push(mh[15].split(sp));
  }
}
professor = professor.flat(1);
professor = [...new Set(professor)];
console.log(professor);
let r = professor.filter((k) => {
  if (k) return k;
});

// fs.writeFile(`data/professor.json`, JSON.stringify(r), (err) => {
//   if (err) console.log(err);
//   console.log("Data written to file");
// });
