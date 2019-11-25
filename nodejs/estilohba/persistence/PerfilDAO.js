function PerfilDAO(db) {
    this._db = db;
}


PerfilDAO.prototype.buscarTodos = function () {
    
	  	var mySort = {name : -1 }
		  this._db.collection("clientes").find().sort(mySort).toArray(function(err, res){
			if(err) throw err;
			console.log(res);
			connection.close();
		});
}

module.exports = function(){
    return PerfilDAO;
};




