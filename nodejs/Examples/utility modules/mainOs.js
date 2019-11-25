var os = require("os");

//Edianness
console.log('endianess: '+os.endianness());

//OS type
console.log('type: '+os.type());

//OS Plataform
console.log('Plataform: '+os.platform());

//Total system memory
console.log('Total memory: '+os.totalmem()+" bytes.");

//Total free memory
console.log('free memory: '+os.freemem()+ "bytes.");
