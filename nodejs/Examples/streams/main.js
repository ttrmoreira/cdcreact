var fs = require('fs');
var data = '';

//Create a readable stream
var readerStream = fs.createReadStream('input.txt');

//Set the encoding to be UTF8
readerStream.setEncoding('UTF8');

//Handle stream events --> data, end, and error
readerStream.on('data', function(chunk){
	data += chunk;
});

readerStream.on('end', function(err){
	console.log(data);
});


//Handle stream events --> data, end, and error
readerStream.on('error', function(err){
	console.log(err.stack);
});


console.log('Program Ended');