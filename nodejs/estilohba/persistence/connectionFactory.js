var mongo = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";
var dbName = 'estilohba';


function createMongoDBConnection(){

	var url = "mongodb://localhost:27017/";

	return  new Promise((resolve, reject) => {

                let dbo;
                mongo.connect(url, function(err, db){

                    if(!err){

                        dbo = db.db(dbName);
                        resolve(dbo);
                        console.log('Database criado!');

                    } else {
                        
                        console.log(err);
                        reject(err);

                    }

                });
 
        });
}

module.exports = function(){

	return createMongoDBConnection;
}


