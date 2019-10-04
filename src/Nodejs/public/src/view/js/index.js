var app = angular.module('myApp', []);

app.controller('myController', myController);

function myController($scope, $http) {

    console.log('Vo roi ne!');
    $scope.thinh = "PVP THINH";
    $http.get('http://localhost:3000/api/getList/SanPham').then(function(result) {
        console.log(result);
        $scope.listData = result.data;
    });
    // $scope.getGiaXe = function() {

    // }


}