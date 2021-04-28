angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8080/demorest/webresources/users').
        then(function(response) {
            $scope.greeting = response.data;
        });
});