const http = require("http");
const url = require("url");

const motoGP = [
  {
    circuit: "Losail",
    location: "Qatar",
    winner: { firstName: "Andrea", lastName: "Dovizioso", country: "Italy" },
  },
  {
    circuit: "Autodromo",
    location: "Argentine",
    winner: { firstName: "Cal", lastName: "Crutchlow", country: "UK" },
  },
  {
    circuit: "De Jerez",
    location: "Spain",
    winner: { firstName: "Valentino", lastName: "Rossi", country: "Italy" },
  },
  {
    circuit: "Mugello",
    location: "Italy",
    winner: { firstName: "Andrea", lastName: "Dovizioso", country: "Italy" },
  },
];

function groupByCountry(data) {
  return data.reduce((result, item) => {
    const country = item.winner.country;
    if (!result[country]) result[country] = [];
    result[country].push(item);
    return result;
  }, {});
}

function groupByName(data) {
  return data.reduce((result, item) => {
    const fullName = `${item.winner.firstName} ${item.winner.lastName}`;
    if (!result[fullName]) result[fullName] = [];
    result[fullName].push(item);
    return result;
  }, {});
}

const server = http.createServer((req, res) => {
  const path = url.parse(req.url, true).pathname;

  if (path === "/") {
    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify(motoGP, null, 2));
  } 
  else if (path === "/country") {
    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify(groupByCountry(motoGP), null, 2));
  } 
  else if (path === "/name") {
    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify(groupByName(motoGP), null, 2));
  } 
  else {
    res.writeHead(400, { "Content-Type": "text/plain" });
    res.end("Bad Request");
  }
});

server.listen(8000, () => {
  console.log("Server berjalan di http://localhost:8000/");
});
