angular.module('sanphamService', [])
    .factory('sanphamService', function ($http) {
        var sanphamFactory = {};
        sanphamFactory.getSanpham = function () {
            return $http.get('/api/sanpham');     
        }
        return sanphamFactory;
    }); 