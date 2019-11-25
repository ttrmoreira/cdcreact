var path = require('path');

//Normalization
console.log('Normalization: '+path.normalize('/test/test1//2slashes/1slashe/tab/..'));

//Join
console.log('joint path:' + path.join('/test', 'test1', '2slashes/1slash', 'tab', '..'));

//Resolve
console.log('resolve: '+path.resolve('mainPath.js'));

//extName
console.log('ext name: '+ path.extname('mainPath.js'));


