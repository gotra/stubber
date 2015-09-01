/**
 * Created by rajeevguru on 02/09/15.
 */
'use strict';

angular.module('stubberApp.newview', ['ngRoute','ngResource'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/new', {
            templateUrl: 'views/new/new.html',
            controller: 'NewStubCtrl'
        });
    }])

    .controller('NewStubCtrl', ['$resource','$scope',function($resource,$scope) {

        var stubdao = $resource('/donotuse/api/stub/:id');



    }]);