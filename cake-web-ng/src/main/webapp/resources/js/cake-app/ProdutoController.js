angular.module('cakeApp').controller('ProdutoController', ['$scope', '$http', '$httpParamSerializer', '$q',
  function ($scope, $http, $httpParamSerializer, $q) {

    $scope.produto = {};
    $scope.listaProdutos = [];

    var urlRest = 'http://localhost:8080/cake-rest/webresources';

    $scope.listar = function () {
      $http({
        method: 'get',
        url: urlRest + '/produto'
      }).then(function (response) {
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
        url: urlRest + '/produto/' + id
      }).then(function (response) {
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

  }]);
