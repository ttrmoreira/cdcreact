var http = require('http');
var porta = 3000;
var ip = "localhost";
var express = require('express');

var server = http.createServer(function(req, res) {
    console.log("Recebendo request");
    res.writeHead( 200, {'Content-Type': 'text/html'});

    if(req.url == '/produtos'){
    	res.end("<html><body><h1>Listando os produtos</h1?</body></html>");
    }else{
    	res.end("<html><body>Home da casa do código</body></html>");
    }

});

server.listen(porta, ip);

console.log("Server running at http://" + ip + ":" + porta + "/");