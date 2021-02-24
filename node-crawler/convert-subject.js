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
// get all subject
let subject = [];
let sp = allData[0][0][14][6];
// console.log(sp);
for (let i = 0; i < allData.length; i++) {
  let element = allData[i];
  // console.log(element[0][5]);
  // element[0].map((item, index) => console.log(index, item));
  subject.push({
    code: element[0][1],
    credit: Number(element[0][5]),
    name: element[0][2],
    fee: 480000 * element[0][5],
  });
}
// subject = subject;
// subject = [...new Set(subject)];
// let r = subject.filter((k) => {
//   if (k) return k;
// });
console.log(subject);
// fs.writeFile(`data/subject.json`, JSON.stringify(subject), (err) => {
//   if (err) console.log(err);
//   console.log("Data written to file");
// });
