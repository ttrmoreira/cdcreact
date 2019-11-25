var fs = require("fs");

console.log("Going to write into a existing file");

fs.writeFile('inputWritten.txt','Simply Easy Learning!', function(err){
	if(err){
		return console.error(err);
	}
	console.log("Data written successfully!");
	console.log("Let's read newly written data");
	fs.readFile('inputWritten.txt', function(err,data){
		if(err){
			return console.error(err);
		}
		console.log("Asynchronous read: "+data.toString());
	});
});