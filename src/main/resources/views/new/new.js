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

        var Stub = $resource('/donotuse/api/stub/:id');

        $scope.save = function(stubToBeSaved) {



            var stub = new Stub();
            stub.name = stubToBeSaved.name;
            stub.description = stubToBeSaved.description;
            stub.urlPath = stubToBeSaved.urlPath;
            stub.httpMethod = stubToBeSaved.httpMethod;
            if (stubToBeSaved.responseHeaders)
                stub.responseHeaders = window.btoa(stubToBeSaved.responseHeaders);

            if (stubToBeSaved.response)
                stub.response = window.btoa(stubToBeSaved.response);

            stub.$save();


        }



    }]);