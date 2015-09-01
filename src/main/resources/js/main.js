'use strict';

// Declare app level module which depends on views, and components
angular.module('stubberApp', [
    'ngRoute',
    'ngResource',
    'stubberApp.homeview',
    'stubberApp.newview'
]).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.otherwise({redirectTo: '/home'});
    }]);
