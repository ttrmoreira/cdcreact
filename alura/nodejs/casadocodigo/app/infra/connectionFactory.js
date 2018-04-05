var mysql  = require('mysql');

function createDBConnection(){

    if (!process.env.NODE_ENV || process.env.NODE_ENV === 'development') {
        return mysql.createConnection({
            host: 'localhost',
            user: 'root',
            password: 'zx4d98pio',
            database: 'casadocodigo_nodejs'
        });
    }

    if (process.env.NODE_ENV == 'test') {
        return mysql.createConnection({
        	
            host: 'localhost',
            user: 'root',
            password: 'zx4d98pio',
            database: 'casadocodigo_nodejs_test'
        });
    }
}

module.exports = function() {
    return createDBConnection;
}