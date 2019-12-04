angular.module('sanphamController', [])
    .controller('sanphamController', function ($http, sanphamService) {
        var app = this;
        this.getSanpham = function () {
            console.log('Get orders-----------------------');
            sanphamService.getSanpham().then(function (data) {
                console.log(data.data);
                app.data = data.data;
                console.log('------------------');
            });

        };
    });