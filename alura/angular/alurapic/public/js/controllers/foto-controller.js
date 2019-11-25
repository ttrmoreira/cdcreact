angular.module('alurapic')
    .controller('FotoController', function($scope, recursoFoto, $routeParams, cadastroDeFoto) {

        $scope.foto = {};
        $scope.mensagem = '';

        if($routeParams.fotoId) {
            recursoFoto.get({fotoId: $routeParams.fotoId}, function(foto) {
                $scope.foto = foto; 
            }, function(erro) {
                console.log(erro);
                $scope.mensagem = 'Não foi possível obter a foto'
            });
        }

        $scope.submeter = function() {
            if ($scope.formulario.$valid) {

                cadastroDeFoto.cadastrar($scope.foto)
                .then(function(dados) {
                    $scope.mensagem = dados.mensagem;
                    if (dados.inclusao) $scope.foto = {};
                    $scope.formulario.$setPristine(); //Comando para impedir a validação de formulário assim que o mesmo for limpo;
                })
                .catch(function(erro) {
                    $scope.mensagem = erro.mensagem;
                });
            }
        };

    });