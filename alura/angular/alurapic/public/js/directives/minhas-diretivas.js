angular.module('minhasDiretivas', [])
    .directive('meuPainel', function() {

        var ddo = {};

        ddo.restrict = "AE";
        ddo.transclude = true;

        ddo.scope = {
            titulo: '@'
        };

       ddo.templateUrl = 'js/directives/meu-painel.html';        

        return ddo;
    }).directive('minhaFoto', () => {
         var ddo = {}

         ddo.restrict="AE";
         ddo.transclude = true;

         ddo.scope = {
             titulo:'@',
             url:'@'
         }

         ddo.template = '<img class="img-responsive center-block" src="{{url}}" alt="{{titulo}}">'

         return ddo;
    }).directive('meuBotaoPerigo', ()=>{

        var ddo = {};

        ddo.restrict="E";
        
        ddo.scope = {
            nome:'@',
            acao:'&'
        }

        ddo.template = '<button ng-click= "acao(foto)" class="btn btn-danger btn-block">{{nome}}</button>'
        return ddo;
    }).directive('meuFocus', function(){
        
        var ddo = {};

        ddo.restrict="A";
        ddo.scope = {
            focado : "="
        };
        ddo.link = function(scope, element) {
            scope.$watch('focado', function(){
                scope.$on('fotoCadastrada', function(){
                    element[0].focus();
                });
            });
        };
        return ddo;

    }).directive('meusTitulos', function(){
        var ddo = {};
        ddo.restrict = "E";
        ddo.template = '<ul><li ng-repeat="titulo in titulos">{{titulo}}</li></ul>';
        ddo.controller = function($scope, recursoFoto){
            recursoFoto.query(function(fotos){
                $scope.titulos = fotos.map(function(foto){
                    return foto.titulo;
                });
            });
        };

        return ddo;
    });