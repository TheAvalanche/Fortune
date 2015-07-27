'use strict';

angular.module('FortuneApp')
    .controller('LineSearchCtrl', function ($scope, $http, LinesService) {
        $scope.lineNumber = 1;
        $scope.findLine = function() {
            LinesService.findLine($scope.lineNumber).success(function (data) {
                console.log(data);
                $scope.line = data.line;
            });
        }
    });