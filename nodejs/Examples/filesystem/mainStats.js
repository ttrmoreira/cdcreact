var fs = require("fs");

console.log("Going to file info!");

fs.stat("input.txt", function(err, teste){
	if(err){
		return console.error(err);
	}

	if(teste.isFile()){
		console.log("Esse é um arquivo porreta!");
	}

	if(teste.isDirectory()){
		console.log("Esse é um diretório");	
	}else{
		console.log("Esse não é um diretório");
	}
	console.log(teste);
	console.log("Got file info successufully!")
})