var express = require('express');
var consign = require('consign');

module.exports = function(){
	var app = express();



	consign()
		.include('controllers')
		.then('persistence')
		.into(app);

	return app;
}
