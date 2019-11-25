angular.module('meusServicos', ['ngResource'])
    .factory('recursoFoto', function($resource) {

        return $resource('/v1/fotos/:fotoId', null, {
            'update' : { 
                method: 'PUT'
            }
        });
    }).factory('cadastroDeFoto', function(recursoFoto, $q, $rootScope){
        var service = {};
        var evento = 'fotoCadastrada';

        service.cadastrar = function(foto){
            return $q (function(resolve, reject){

                if(foto._id){
                    recursoFoto.update({fotoId: foto._id}, 
                        foto, function() {
                        /*Injetei o $rootScope e a partir dele disparo o evento fotoCadastrada quando a 
                        foto for incluída ou alterada. Como ele é o pai de todos os escopos dos controllers, 
                        os $scope também serão afetados pelo disparo do evento: */
                            $rootScope.$broadcast(evento);
                            resolve({
                                mensagem : 'Foto alterada com sucesso',
                                incluir : false
                            }),
                            reject({
                                mensagem : 'Não foi possível atualizar a foto '+ foto.titulo
                            })
                        
                    }, function(erro) {
                        console.log(erro);
                        reject({
                            mensagem : 'Não foi possível alterar a foto '+foto.titulo
                        });
                    });
                }else{
                    recursoFoto.save(foto, function() {
                        /*Injeção do $rootScope para inclusão */
                        $rootScope.$broadcast(evento);
                        resolve({
                            mensagem : 'Foto cadastrada com sucesso',
                            incluir : true
                        });
                    }, function(erro) {
                        console.log(erro);
                        reject({
                            mensagem : 'Não foi possível cadastrar a foto'
                        });
                    });
                }
            });
        };
        return service;
    });