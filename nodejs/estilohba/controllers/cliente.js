module.exports = function(app){
    app.get('/', function(req, res){
        console.log('Teste de requisição de rota');
		let connection = app.persistence.connectionFactory();
		connection
			.then(dbo => {
				  dbo.collection("clientes").find({}).toArray(function(err, result) {
    				if (err) throw err;
    				console.log(result);
    				db.close();
  					});
				console.log('Funcionou');
			})
			.catch(error => console.log(error + "Não funcionou"));

		// var connection = ConnectionFactoryMongo.getConnection();
		// var perfilDAO = new app. persistence.PerfilDAO(connection);
		//ConnectionFactoryMongo.getConnection().then(connection => console.log('Funcionou'));
        res.send('Teste');





    })
}