'use strict';

angular
    .module('FortuneApp', [
        'ngRoute',
        'ngSanitize'
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/line-search-view.html',
                controller: 'LineSearchCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
