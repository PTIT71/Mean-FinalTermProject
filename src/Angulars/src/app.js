var app = angular.module('myApp', []);

app.controller('myController', myController);

function myController($scope, $http) {
  $scope.title = 'Xin chao!!!';
  $scope.userName = '';
  $scope.userId = 0;

  $scope.getName = function() {
    $http.get('/api/getName/' + $scope.userId).then(function(result) {
      $scope.userName = result.data;
    });
  }
  $scope.TenXe = '';
  $scope.tenxe= 'xeA';
  $scope.getGiaXe = function() {
    $http.get('/api/getGiaXe/' + $scope.tenxe).then(function(result) {
      $scope.TenXe = result.data;
    });
  }

 
}

