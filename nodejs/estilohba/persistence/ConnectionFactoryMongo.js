
var mongo = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";
var dbName = 'estilohba';

class ConnectionFactoryMongo {

    constructor() {

        throw new Error('Não é possível criar instâncias de ConnectionFactory');
    }

    static getConnection() {

        return new Promise((resolve, reject) => {

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

    
}



