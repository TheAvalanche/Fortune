'use strict';

angular.module('FortuneApp')
    .factory('LinesService', ['$http', function ($http) {
        var restRoot = '/lines';

        return {
            findLine: function(line) {
                return $http.get(restRoot + '/find/' + line);
            }
        };
    }]);