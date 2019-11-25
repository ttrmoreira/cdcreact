//Printing to console
process.stdout.write("Hello World" + "\n");

//Reading passed parameter
process.argv.forEach(function(val,index, array){
	console.log(index + ': ' + val);
});

//Getting executable path
console.log(process.execPath);

//Plataform Information
console.log(process.plataform);

	