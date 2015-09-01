'use strict';

angular.module('stubberApp.homeview', ['ngRoute','ngResource'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/home', {
            templateUrl: 'views/home/home.html',
            controller: 'HomeCtrl'
        });
    }])

    .controller('HomeCtrl', ['$resource','$scope',function($resource,$scope) {

        var stubdao = $resource('/donotuse/api/stub/:id');

        stubdao.query(function(stubs){
            $scope.stubs = stubs;
        })

        $scope.deleteStub = function(stub){
            stubdao.delete({id: stub.id},function(data){
                if (data.rows > 0) {
                    var index = $scope.stubs.indexOf(stub);
                    $scope.stubs.splice(index, 1);

                }

            });

        }

    }]);