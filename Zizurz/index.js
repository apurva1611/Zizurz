const fs = require('fs');
const http = require('http');
const url = require('url');
const replaceTemplate = require('./modules/replace-template');
// synchronous code
const dataString = fs.readFileSync(`${__dirname}/dev-data/data.json`, 'utf-8');
const dataObject = JSON.parse(dataString);
const templateOverView = fs.readFileSync(
  `${__dirname}/templates/template-overview.html`,
  'utf-8'
);
const templateCard = fs.readFileSync(
  `${__dirname}/templates/template-card.html`,
  'utf-8'
);
const templateProduct = fs.readFileSync(
  `${__dirname}/templates/template-product.html`,
  'utf-8'
);
// Https server
const server = http.createServer((req, res) => {
  const urlHit = url.parse(req.url, true); // true to get query object
  const pathName = urlHit.pathname;
  const query = urlHit.query;
  // Default Page
  if (pathName == '/' || pathName == '/overview') {
    res.writeHead(200, {
      'Content-type': 'text/html'
    });
    const templateCardsHTML = dataObject
      .map(product => replaceTemplate(product, templateCard))
      .join('');
    const cardsInHTML = templateOverView.replace(
      '{%PRODUCT_CARDS%}',
      templateCardsHTML
    );
    res.end(cardsInHTML);
  } else if (pathName == '/product') {
    res.writeHead(200, {
      'Content-type': 'text/html'
    });
    const product = dataObject[query.id];
    const productHTML = replaceTemplate(product, templateProduct);
    res.end(productHTML);
  } else {
    res.writeHead(404, {
      'Content-type': 'text/html'
    });
    res.end('<h1> Page Not Found<h1>');
  }
});
server.listen(8000, '127.0.0.1', () => {
  console.log('Listening to requests on port 8000');
});
