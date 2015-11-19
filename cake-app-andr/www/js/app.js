// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic', 'ui.bootstrap', 'starter.controllers'])

        .run(function ($ionicPlatform) {
          $ionicPlatform.ready(function () {
            // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
            // for form inputs)
            if (window.cordova && window.cordova.plugins.Keyboard) {
              cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
              cordova.plugins.Keyboard.disableScroll(true);

            }
            if (window.StatusBar) {
              // org.apache.cordova.statusbar required
              StatusBar.styleDefault();
            }
          });
        })
		.constant('RestApiUrl', '')
		.value('carrinho', {  itens : [] }) 
        .factory('CarrinhoService', ['$rootScope', 'carrinho', function ($rootScope, carrinho) {
            // if (!$rootScope.carrinho) {
              // $rootScope.carrinho = [];
            // }
            // return {
              // adicionarItem: function (produto) {
                // $rootScope.carrinho[$rootScope.carrinho.length] = {
                  // produto: produto,
                  // data: new Date()
                // };
                // return $rootScope.carrinho.length;
              // },
              // getCarrinho: function () {
                // return $rootScope.carrinho;
              // }
            // };
			alert("executou service");
			var xpto = JSON.parse(localStorage.getItem("carrinho"));
			if (!xpto) {
				xpto = [];
			}
			return {
				adicionarItem: function(produto) {
					var item = {
						produto : produto,
						data : new Date()
					};
					//carrinho.itens.push(item);
					//return carrinho.itens.length;
					xpto.push(item);
					localStorage.setItem("carrinho", JSON.stringify(xpto));
					return xpto.length;
				},
				getCarrinho: function() {
					alert(JSON.stringify(xpto));
					return xpto;
				},
				limparCarrinho: function() {
					xpto = [];
					localStorage.removeItem("carrinho");
				}
			};
			
          }])
        .config(function ($stateProvider, $urlRouterProvider) {
          $stateProvider

                  .state('app', {
                    url: '/app',
                    abstract: true,
                    templateUrl: 'templates/principal.html',
                    controller: 'AppCtrl'
                  })
/*
                  .state('app.search', {
                    url: '/search',
                    views: {
                      'menuContent': {
                        templateUrl: 'templates/search.html'
                      }
                    }
                  })

                  .state('app.browse', {
                    url: '/browse',
                    views: {
                      'menuContent': {
                        templateUrl: 'templates/browse.html'
                      }
                    }
                  })
*/
                  .state('app.lista', {
                    url: '/lista',
                    views: {
                      'menuContent': {
                        templateUrl: 'templates/lista.html',
                        controller: 'ProdutoCtrl'
                      }
                    }
                  })

                  .state('app.detalhe', {
                    url: '/detalhe/:prodId',
                    views: {
                      'menuContent': {
                        templateUrl: 'templates/detalhe.html',
                        controller: 'ProdutoCtrl'
                      }
                    }
                  });
          // if none of the above states are matched, use this as the fallback
          $urlRouterProvider.otherwise('/app/lista');
        });
