process.stdout.write("\033c");
const fs = require("fs");
const _ = require("lodash");
//import end

let listMH = fs.readdirSync("./node-crawler/json");
//loop all mh => all data
let allData = listMH.map((mh) => {
  let dataFile = fs.readFileSync(`./node-crawler/json/${mh}`);
  return JSON.parse(dataFile);
});
// console.log(allData.flat(3));
// get all classs
let classs = [];
let sp = allData[0][0][14][6];
// console.log(sp);
for (let i = 0; i < allData.length; i++) {
  let element = allData[i];
  for (let j = 0; j < element.length; j++) {
    let mh = element[j];
    // console.log(mh[16].split(sp), mh[2]);
    let weeks = mh[16].split(sp);
    let spWeeks = weeks.map((w) => w.split(""));
    // console.log(spWeeks);

    let time = mh[11].split(sp);
    let lesson = mh[12].split(sp);
    let room = mh[14].split(sp);
    let professor = mh[15].split(sp);
    classs.push({
      nmh: mh[3],
      quantity: Number(mh[8]),
      slot: Number(mh[8]),
      tth: Number(mh[4]),
      // thu: mh[11].split(sp),
      // tbd: mh[12].split(sp),
      subject: {
        code: mh[1],
        name: mh[2],
        credit: Number(mh[5]),
      },
      details: time.map((thu, index) => {
        // let ww = spWeeks[index].filter((w, j) => {
        //   if (w !== "-") {
        //     // console.log(Number(w) + 10);
        //     let r = { name: Number(w) };
        //     if (j >= 10) {
        //       r.name = Number(w) + Number(j);
        //       // console.log(JSON.stringify(r));
        //     }
        //     // console.log(j);
        //     return r;
        //   }
        // });
        // console.log(JSON.stringify(ww));
        let we = spWeeks[index];
        let ww = [];
        for (let k = 0; k < we.length; k++) {
          if (we[k] !== "-") {
            let element = k+1;
            // if (k >= 9) element +=1;
            // console.log("element", element);
            ww.push({ name: element });
          }
        }
        // console.log(ww);
        return {
          time: { name: thu, lesson: lesson[index] },
          room: { name: room[index] },
          professor: { name: professor[index] },
          weeks: ww,
        };
      }),
    });
  }
}
// classs = classs.flat(1);
// classs = [...new Set(classs)];
// let r = classs.filter((k) => {
//   if (k) return k;
// });
console.log(JSON.stringify(classs[0].details));
// fs.writeFile(`./node-crawler/data/classs.json`, JSON.stringify(classs), (err) => {
//   if (err) console.log(err);
//   console.log("Data written to file");
// });
