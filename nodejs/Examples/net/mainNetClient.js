var net = require('net');
console.log('#### Client iniciado #####')
var client = net.connect({port: 8080}, function() {
	console.log('connected to server!');
});
client.on('data', function(data) {
	console.log(data.toString());
	client.end();
});
client.on('end', function() {
console.log('disconnected from server');
});

