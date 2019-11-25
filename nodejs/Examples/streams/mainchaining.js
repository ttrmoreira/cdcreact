var fs = require('fs');
var zlib = require('zlib');

//fs.createReadStream('input.txt').pipe(zlib.createGzip()).pipe(fs.createWriteStream('input.txt.zip'));

fs.createReadStream('input.txt.zip').pipe(zlib.createGunzip()).pipe(fs.createWriteStream('unziped.txt'));

console.log('File Decompressed');