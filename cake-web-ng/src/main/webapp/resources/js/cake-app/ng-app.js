angular.module('cakeApp', ['ui.router'])
        .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise('/lista');
            $stateProvider
                    .state('lista', {
                      url: '/lista',
                      templateUrl: 'partials/lista.html'
                    })
                    .state('detalhe', {
                      url: '/detalhe/:prodId', // ou 'detalhe/{prodId}
                      templateUrl: 'partials/detalhe.html'
                    });
          }]);