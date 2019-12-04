angular.module('sanphamService', [])
    .factory('sanphamService', function ($http) {
        var sanphamFactory = {};
        sanphamFactory.getSanpham = function () {
            return $http.get('localhost:3000/sanpham');     
        }
        console.log(sanphamFactory);
        return sanphamFactory;
    }); 