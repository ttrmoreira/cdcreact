/*Quando uma função não é chamada o tempo inteiro as instruções podem permanecer 
fora da função, dessa forma a mesma versão da função será chamada o tempo inteiro. 
Caso houvesse versões diferentes aí seria interessante manter esse trecho de código
dentro da função*/
var express = require('express');
var load = require('express-load');
var bodyParser = require('body-parser');
var expressValidator = require('express-validator');

module.exports = function() {
    var app = express();

    app.use(express.static('./app/public'));
    app.set('view engine', 'ejs');
    app.set('views', './app/views');

    app.use(bodyParser.urlencoded({extended: true}));
    app.use(bodyParser.json());
    app.use(expressValidator());

    load('routes', {cwd: 'app'})
        .then('infra')
        .into(app);

    app.use(function(req, res, next){
        res.status(404).render("erros/404");
        next();
    });

    app.use(function(error, req, res, next){
        if (process.env.NODE_ENV  == 'production') {
            res.status(500).render("erros/500");
            return
        }
        next(error);
    });


    return app;
}






