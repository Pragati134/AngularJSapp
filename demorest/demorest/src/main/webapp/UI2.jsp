<!DOCTYPE html>

<html>

<head>

<title>

AngularJs $http.get() Service Response Example

</title>

<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<script type="text/javascript">

var app = angular.module('serviceApp', []);

app.controller('serviceCtrl', function ($scope, $http) {

$http({

method: 'GET',

url: 'http://localhost:8080/demorest/webresources/users'

}).then(function success(response) {

$scope.myWelcome = response.data;

$scope.statusval = response.status;

$scope.statustext = response.statusText;

$scope.headers = response.headers();

}, function error(response) {

});

});

</script>

</head>

<body>

<div ng-app="serviceApp" ng-controller="serviceCtrl">

<p>Hi, Guest</p>

<h6>{{myWelcome}}</h6>
 <ul>
        <li ng-repeat="d in myWelcome">
            {{ d.userid + ' ' + d.username + ', ' + d.email}}
        </li>
    </ul>
    <p ng-bind="ResponseDetails"></p>
    {{ResponseDetails}}<p>StatusCode: {{statusval}}</p>

<p>Status: {{statustext}}</p>

<p>Response Headers: {{headers}}</p>

</div>

</body>

</html>