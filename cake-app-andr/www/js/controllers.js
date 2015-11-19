angular.module('starter.controllers', ['ui.bootstrap'])
        //.value('carrinho', [])
//        .run(function ($rootScope) {
//          alert("rodando starter.controllers");
//          if (!$rootScope.carrinho) {
//            $rootScope.carrinho = [];
//          }
//        })

        .controller('AppCtrl', ['$scope', '$ionicModal', '$timeout', '$state', 'CarrinhoService',
          function ($scope, $ionicModal, $timeout, $state, CarrinhoService) {
			  
            $scope.carrinho = CarrinhoService.getCarrinho();
            $scope.adicionar = function (produto) {
              CarrinhoService.adicionarItem(produto);
              alert("AppCtrl: carrinho com " + CarrinhoService.getCarrinho().length + " items");
			  $state.go('app.lista');
            };
			
			$scope.limpar = function() {
				CarrinhoService.limparCarrinho();
			}; 

            alert("AppCtrl: carrinho com " + CarrinhoService.getCarrinho().length + " items");
			  
            $scope.categorias = [{"id": 1, "nome": "Bolo"},
              {"id": 2, "nome": "Torta"}, {"id": 3, "nome": "Chocolate"},
              {"id": 4, "nome": "Morango"}, {"id": 5, "nome": "Light"},
              {"id": 6, "nome": "Crocante"}, {"id": 7, "nome": "Abacaxi"},
              {"id": 8, "nome": "Coco"}];

            // With the new view caching in Ionic, Controllers are only called
            // when they are recreated or on app start, instead of every page change.
            // To listen for when this page is active (for example, to refresh data),
            // listen for the $ionicView.enter event:
            //$scope.$on('$ionicView.enter', function(e) {
            //});

            // Form data for the login modal
            $scope.loginData = {};

            // Create the login modal that we will use later
            $ionicModal.fromTemplateUrl('templates/login.html', {
              scope: $scope
            }).then(function (modal) {
              $scope.modal = modal;
            });

            // Triggered in the login modal to close it
            $scope.closeLogin = function () {
              $scope.modal.hide();
            };

            // Open the login modal
            $scope.login = function () {
              $scope.modal.show();
            };

            // Perform the login action when the user submits the login form
            $scope.doLogin = function () {
              console.log('Doing login', $scope.loginData);

              // Simulate a login delay. Remove this and replace with your login
              // code if using a login system
              $timeout(function () {
                $scope.closeLogin();
              }, 1000);
            };
          }])

        .controller('ProdutoCtrl', ['$scope', '$http', '$httpParamSerializer', '$q', 'RestApiUrl',
          function ($scope, $http, $httpParamSerializer, $q, RestApiUrl) {

            $scope.produto = {"categorias": [{"id": 1, "nome": "Bolo"}, {"id": 3, "nome": "Chocolate"}], "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. Suspendisse commodo cursus turpis. Etiam ac enim egestas, sollicitudin libero ac, eleifend risus. Phasellus nec posuere magna, in vehicula elit. Etiam rhoncus, ipsum eget dapibus vulputate, massa nisi feugiat odio, a consectetur urna diam id risus. Morbi sed pharetra nisl, nec aliquam ex. Morbi congue urna ut semper aliquam. Sed aliquet turpis ac sem egestas dignissim. Praesent interdum dapibus cursus. Cras posuere tempor lectus, ac porttitor tellus maximus vel.", "id": 1, "imagens": [{"id": 1, "legenda": "Bla bla bla", "nomeArquivo": "imagem01a.jpg"}, {"id": 2, "legenda": "Xpto Xpto", "nomeArquivo": "imagem01b.jpg"}, {"id": 3, "legenda": "Chola mais", "nomeArquivo": "imagem01c.jpg"}], "nome": "Floresta negra", "preco": 100};
            $scope.listaProdutos = [{"categorias": [{"id": 1, "nome": "Bolo"}, {"id": 3, "nome": "Chocolate"}], "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. Suspendisse commodo cursus turpis. Etiam ac enim egestas, sollicitudin libero ac, eleifend risus. Phasellus nec posuere magna, in vehicula elit. Etiam rhoncus, ipsum eget dapibus vulputate, massa nisi feugiat odio, a consectetur urna diam id risus. Morbi sed pharetra nisl, nec aliquam ex. Morbi congue urna ut semper aliquam. Sed aliquet turpis ac sem egestas dignissim. Praesent interdum dapibus cursus. Cras posuere tempor lectus, ac porttitor tellus maximus vel.", "id": 1, "imagens": [{"id": 1, "legenda": "Bla bla bla", "nomeArquivo": "imagem01a.jpg"}, {"id": 2, "legenda": "Xpto Xpto", "nomeArquivo": "imagem01b.jpg"}, {"id": 3, "legenda": "Chola mais", "nomeArquivo": "imagem01c.jpg"}], "nome": "Floresta negra", "preco": 100}, {"categorias": [{"id": 1, "nome": "Bolo"}, {"id": 3, "nome": "Chocolate"}], "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. Suspendisse commodo cursus turpis. Etiam ac enim egestas, sollicitudin libero ac, eleifend risus. Phasellus nec posuere magna, in vehicula elit. Etiam rhoncus, ipsum eget dapibus vulputate, massa nisi feugiat odio, a consectetur urna diam id risus. Morbi sed pharetra nisl, nec aliquam ex. Morbi congue urna ut semper aliquam. Sed aliquet turpis ac sem egestas dignissim. Praesent interdum dapibus cursus. Cras posuere tempor lectus, ac porttitor tellus maximus vel.", "id": 2, "imagens": [{"id": 4, "legenda": "Bla bla bla", "nomeArquivo": "imagem02a.jpg"}, {"id": 5, "legenda": "Xpto Xpto", "nomeArquivo": "imagem02b.jpg"}], "nome": "Torta de morango", "preco": 90}, {"categorias": [{"id": 1, "nome": "Bolo"}, {"id": 3, "nome": "Chocolate"}, {"id": 6, "nome": "Crocante"}], "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. Suspendisse commodo cursus turpis. Etiam ac enim egestas, sollicitudin libero ac, eleifend risus. Phasellus nec posuere magna, in vehicula elit. Etiam rhoncus, ipsum eget dapibus vulputate, massa nisi feugiat odio, a consectetur urna diam id risus. Morbi sed pharetra nisl, nec aliquam ex. Morbi congue urna ut semper aliquam. Sed aliquet turpis ac sem egestas dignissim. Praesent interdum dapibus cursus. Cras posuere tempor lectus, ac porttitor tellus maximus vel.", "id": 3, "imagens": [{"id": 6, "legenda": "Bla bla bla", "nomeArquivo": "imagem03a.jpg"}], "nome": "Sonho de valsa", "preco": 110}, {"categorias": [{"id": 1, "nome": "Bolo"}, {"id": 4, "nome": "Morango"}], "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. Suspendisse commodo cursus turpis. Etiam ac enim egestas, sollicitudin libero ac, eleifend risus. Phasellus nec posuere magna, in vehicula elit. Etiam rhoncus, ipsum eget dapibus vulputate, massa nisi feugiat odio, a consectetur urna diam id risus. Morbi sed pharetra nisl, nec aliquam ex. Morbi congue urna ut semper aliquam. Sed aliquet turpis ac sem egestas dignissim. Praesent interdum dapibus cursus. Cras posuere tempor lectus, ac porttitor tellus maximus vel.", "id": 4, "imagens": [{"id": 7, "legenda": "Bla bla bla", "nomeArquivo": "imagem04a.jpg"}, {"id": 8, "legenda": "Xpto Xpto", "nomeArquivo": "imagem04b.jpg"}], "nome": "Morango com leite condensado", "preco": 105}, {"categorias": [{"id": 1, "nome": "Bolo"}, {"id": 5, "nome": "Light"}, {"id": 7, "nome": "Abacaxi"}, {"id": 8, "nome": "Coco"}], "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. Suspendisse commodo cursus turpis. Etiam ac enim egestas, sollicitudin libero ac, eleifend risus. Phasellus nec posuere magna, in vehicula elit. Etiam rhoncus, ipsum eget dapibus vulputate, massa nisi feugiat odio, a consectetur urna diam id risus. Morbi sed pharetra nisl, nec aliquam ex. Morbi congue urna ut semper aliquam. Sed aliquet turpis ac sem egestas dignissim. Praesent interdum dapibus cursus. Cras posuere tempor lectus, ac porttitor tellus maximus vel.", "id": 5, "imagens": [{"id": 9, "legenda": "Bla bla bla", "nomeArquivo": "imagem04a.jpg"}, {"id": 10, "legenda": "Xpto Xpto", "nomeArquivo": "imagem04b.jpg"}], "nome": "Abacaxi com coco", "preco": 85}];
            //$scope.produto = {};
            //$scope.listaProdutos = [];

            //var urlRest = 'http://localhost:8080/cake-rest/webresources';

            $scope.listar = function () {
              $http({
                method: 'get',
                url: RestApiUrl + '/cake-rest/webresources/produto'
              }).then(
                      function (response) {
                        // caso de sucesso
                        $scope.listaProdutos = response.data;
                      },
                      function (response) {
                        if (!angular.isObject(response.data) || !response.data.message) {
                          return ($q.reject("An unknown error occurred."));
                        }
                        $q.reject(response.data.message);
                      });
            };

            $scope.obter = function (id) {
              $http({
                method: 'get',
                url: RestApiUrl + '/cake-rest/webresources/produto/' + id
              }).then(
                      function (response) {
                        // caso de sucesso
                        $scope.produto = response.data;
                      },
                      function (response) {
                        if (!angular.isObject(response.data) || !response.data.message) {
                          return ($q.reject("An unknown error occurred."));
                        }
                        $q.reject(response.data.message);
                      });
            };

            $scope.$on('$stateChangeSuccess',
                    function (event, toState, toParams, fromState, fromParams) {
                      if (toState.name === 'app.lista') {
                        //var element = document.getElementById('areaconteudo');
                        //var scp = angular.element(element).scope();
                        //scp.listar();
                        $scope.listar();
                      } else if (toState.name === 'app.detalhe') {
                        //angular.element(document.getElementById('areaconteudo')).scope().obter(toParams.prodId);
                        $scope.obter(toParams.prodId);
                      }
                    });
          }])
		  /*
        .controller('CarrinhoCtrl', ['$scope', '$state', 'CarrinhoService', function ($scope, $state, CarrinhoService) {

            $scope.carrinho = CarrinhoService.getCarrinho();
            $scope.adicionar = function (produto) {
              CarrinhoService.adicionarItem(produto);
              alert("carrinho com " + $scope.carrinho.length + " items");
			  $state.go("app.lista");
            };

            alert("carrinho com " + $scope.carrinho.length + " items");
          }]);
		  */

//        .controller('ProdutoCtrl', ['$scope', '$stateParams', function ($scope, $stateParams) {
//          }]);
