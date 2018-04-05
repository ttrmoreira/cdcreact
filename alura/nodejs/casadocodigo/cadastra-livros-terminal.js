var http = require('http');


var configuracoes = {
	hostName:'localhost',
	port:3000,
	path:'/produtos',
	method:'post',
	headers:{
		'Accept':'application/json',
		'Content-Type':'application/json'
	}

};



 var client = http.request(configuracoes, function(res){
	console.log(res.statusCode);
	res.on('data',function(body){
		console.log('Corpo:'+body);
	});
});

var produto = {
		titulo:'NodeJS Top das Galáxias',
		descricao:'O livro mais top de todos os tempos',
		preco:100
	};

	console.log(produto);

 client.end(JSON.stringify(produto));