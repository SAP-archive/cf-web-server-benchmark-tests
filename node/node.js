const http = require('http');

http.createServer(function (req, res) {
  if (req.url == '/random') {
    res.write(""+ Math.random());
  } else if (req.url == '/fibonacci'){
    const fibo = fib()
    for (let i=0; i<75; i++){
      res.write(fibo() + '\n')
    }
  } else {
    res.write('Hello SAP Cloud Platform!')
  }
  res.end();
}).listen(process.env.PORT  || 3000);

function fib() {
  let x = 0
  let y = 1
  return function () {
    const temp = x;
    x = y;
    y = temp + y;
    return x
  }
}
