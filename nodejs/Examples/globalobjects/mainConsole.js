console.info("Program Started");

var counter = 10;

console.log("Counter: %d", counter);

console.time("Getting data");

//Do some processing here...

for(var x = 1; x <= 10; x++){
	console.log("Contador"+ counter++);
}

console.timeEnd("Getting data");

console.info("Program Ended");