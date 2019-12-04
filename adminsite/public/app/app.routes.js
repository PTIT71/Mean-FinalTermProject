angular.module('routerRoutes', ['ngRoute'])
    .config(function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'app/views/pages/dashbroad.html',
                controller: 'homeController',
                controllerAs: 'home'   
            })

            .when('/thongke', {
                templateUrl: 'app/views/pages/chart.html',
                controller: 'aboutController',
                controllerAs: 'about'
            })
            .when('/khachhang', {
                templateUrl: 'app/views/pages/khachhang.html',
                controller: 'contactController',
                controllerAs: 'contact'
            })
            .when('/loai', {
                templateUrl: 'app/views/pages/loaisanpham.html',
                controller: 'loaiController',
                controllerAs: 'loai'
            })
            .when('/sanpham', {
                templateUrl: 'app/views/pages/tables.html',
                controller: 'sanphamController',
                controllerAs: 'sanpham'
            })
        $locationProvider.html5Mode(true);
    })