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
        $routeProvider.when('/edit/:id', {
            templateUrl: 'views/new/new.html',
            controller: 'NewStubCtrl'
        });

    }])

    .controller('NewStubCtrl', ['$resource','$scope','$routeParams', '$route', '$location',
        function($resource,$scope,$routeParams,$route,$location) {

        $scope.stub = {};
        $scope.isEdit = false;



        $scope.responseHeadersList =[];

        $scope.addResponseHeader = function() {
            var newItemNo = $scope.responseHeadersList.length+1;
            $scope.responseHeadersList.push({'id': newItemNo});
        };

        $scope.removeResponseHeader = function(idx) {
         $scope.responseHeadersList.splice(idx,1);
        };


        //

        var Stub = $resource('/donotuse/api/stub/:id',{id:'@id'},{
            update: {method:'PUT'}
        });

        $scope.items =[{name:"GET",label:"HTTP-GET"},
            {name:"POST",label:"HTTP-POST"},
            {name:"PUT",label:"HTTP-PUT"}];

        $scope.save = function(stubToBeSaved) {


            var stub = new Stub();
            stub.name = stubToBeSaved.name;
            stub.description = stubToBeSaved.description;
            stub.urlPath = stubToBeSaved.urlPath;
            stub.httpMethod = stubToBeSaved.httpMethod ? stubToBeSaved.httpMethod.name:'GET';
            stubToBeSaved.headers='';

            for(var x =0; x < $scope.responseHeadersList.length; x++) {
                var obj = $scope.responseHeadersList[x];
                if (obj.headerName){
                    var pair = obj.headerName + ":" + obj.headerValue;

                    stubToBeSaved.headers += pair + "||";
                }

            }
            if (stubToBeSaved.headers)
                stubToBeSaved.headers = stubToBeSaved.headers.substring(0,stubToBeSaved.headers.length-2);

            if (stubToBeSaved.headers)
                stub.headers = window.btoa(stubToBeSaved.headers);

            if (stubToBeSaved.response)
                stub.response = window.btoa(stubToBeSaved.response);

            if ($scope.isEdit) {

                stub.id = stubToBeSaved.id
                stub.$update(function(val,responseHeaders){
                    $location.path('/');
                });

            }
            else
            {
                stub.$save(function(val,responseHeaders){
                    $location.path('/');
                });
            }




        }


        if ($route.current.originalPath == "/edit/:id") {

            $scope.isEdit = true;

            Stub.get({id:$routeParams.id},function(stub){
                $scope.stub = stub;

                var headers = stub.headers, httpMethod = stub.httpMethod;
                if (httpMethod) {

                    for (var x=0; x <$scope.items.length; x++) {

                        if ($scope.items[x].name == httpMethod) {
                            $scope.stub.httpMethod = $scope.items[x];
                            break;
                        }

                    }

                }
                if (headers) {
                    var list = headers.split('||'),
                        newlist = [];
                    for (var x=0; x <list.length; x++) {
                        var _namevalue = list[x].split(':');

                        newlist.push({id:x+1,headerName: _namevalue[0],headerValue: _namevalue[1]});

                    }
                    $scope.responseHeadersList = newlist;
                }

            });




        }



    }]);



