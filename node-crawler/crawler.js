const cheerio = require("cheerio");
const fs = require("fs");
const fetch = require("node-fetch");

const crawler = async (id) => {
  let data = await fetch(
    "http://qldt.ptit.edu.vn/ajaxpro/EduSoft.Web.UC.DangKyMonHoc,EduSoft.Web.ashx",
    {
      headers: {
        accept: "*/*",
        "accept-language": "en-GB,en-US;q=0.9,en;q=0.8,vi;q=0.7",
        "content-type": "text/plain; charset=UTF-8",
        "x-ajaxpro-method": "LocTheoMonHoc",
        cookie: "ASP.NET_SessionId=xxxxx",
      },
      referrer: "http://qldt.ptit.edu.vn/Default.aspx?page=dkmonhoc",
      referrerPolicy: "strict-origin-when-cross-origin",
      body: `{\"dkLoc\":\"${id}\"}`,
      method: "POST",
      mode: "cors",
    }
  ).then((res) => res.json());
  let r = data.value;
  let $ = cheerio.load(r);
  let tr = $(r).find("tr");
  let rstr = [];
  //loop tr
  tr.each(function (i, e) {
    let td = $(this).find("td");
    let rstd = [];
    //loop td
    td.each(function (j, t) {
      let data = $(this).text();
      rstd.push(data);
    });
    rstr.push(rstd);
  });
  return rstr;
};

// crawler("BAS1146");

const list = [
  "BAS1144",
  "BAS1146",
  "INT1313",
  "INT1319",
  "INT1330",
  "INT1332",
  "SKD1101",
  "SKD1102",
  "SKD1108",
];

const getData = async function (list) {
  console.log(list);
  for (const name of list) {
    let json = await crawler(name).then((r) => JSON.stringify(r));
    // write to file
    fs.writeFile(`json/${name}.json`, json, (err) => {
      if (err) console.log(err);
      console.log("Data written to file", name);
    });
  }
};

getData(list);
