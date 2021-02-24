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
// get all rooms
let rooms = [];
let sp = allData[0][0][14][6];
// console.log(sp);
for (let i = 0; i < allData.length; i++) {
  let element = allData[i];
  for (let j = 0; j < element.length; j++) {
    let mh = element[j];
    // console.log(mh[14],mh[14][6]);
    rooms.push(mh[14].split(sp));
  }
}
rooms = rooms.flat(1);
rooms = [...new Set(rooms)];
let r = rooms.filter((k) => {
  if (k) return k;
});
// console.log(r);
fs.writeFile(`data/rooms.json`, JSON.stringify(r), (err) => {
  if (err) console.log(err);
  console.log("Data written to file");
});
// console.log(rooms.flat(1));
// let rawdata = fs.readFileSync(`./json/${listMH[0]}`);
// let dataParse = JSON.parse(rawdata);
// //room
// let rooms = dataParse.map((mh) => mh[14]);

// console.log(rooms);
