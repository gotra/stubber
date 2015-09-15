/**
 * Created by rajeevguru on 02/09/15.
 */
'use strict';

angular.module('stubberApp.newview', ['ngRoute','ngResource','siyfion.sfTypeahead'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/new', {
            templateUrl: 'views/new/new.html',
            controller: 'NewStubCtrl'
        });
    }])

    .controller('NewStubCtrl', ['$resource','$scope',function($resource,$scope) {

        $scope.stub = {};


        //
        // instantiate the bloodhound suggestion engine
        var numbers = new Bloodhound({
            datumTokenizer: Bloodhound.tokenizers.whitespace,
            queryTokenizer: Bloodhound.tokenizers.whitespace,
            local: [
                "Accept",
                "Accept-Charset",
                "Accept-Encoding",
                "Accept-Language",
                "Accept-Datetime",
                "Authorization",
                "Cache-Control",
                "Connection",
                "Cookie",
                "Content-Length",
                "Content-MD5",
                "Content-Type",
                "Date",
                "Expect",
                "From",
                "Host",
                "If-Match",
                "If-Modified-Since",
                "If-None-Match",
                "If-Range",
                "If-Unmodified-Since",
                "Max-Forwards",
                "Origin",
                "Pragma",
                "Proxy-Authorization",
                "Range",
                "Referer [sic]",
                "TE",
                "User-Agent",
                "Upgrade",
                "Via",
                "Warning"
            ]
        });

        // initialize the bloodhound suggestion engine
        numbers.initialize();

        $scope.responseHeadersDataset = {

            source: numbers.ttAdapter()
        };

        // Typeahead options object
        $scope.exampleOptions = {
            highlight: true
        };

        $scope.responseHeadersList =[{id:1}];

        $scope.addResponseHeader = function() {
            var newItemNo = $scope.responseHeadersList.length+1;
            $scope.responseHeadersList.push({'id': newItemNo});
        };

        $scope.removeResponseHeader = function(idx) {



            $scope.responseHeadersList.splice(idx,1);
        };




        //

        var Stub = $resource('/donotuse/api/stub/:id');

        $scope.items =[{name:"GET",label:"HTTP-GET"},
            {name:"POST",label:"HTTP-POST"},
            {name:"PUT",label:"HTTP-PUT"}];

        $scope.save = function(stubToBeSaved) {



            var stub = new Stub();
            stub.name = stubToBeSaved.name;
            stub.description = stubToBeSaved.description;
            stub.urlPath = stubToBeSaved.urlPath;
            stub.httpMethod = stubToBeSaved.httpMethod ? stubToBeSaved.httpMethod.name:'GET';
            stubToBeSaved.responseHeaders='';

            for(var x =0; x < $scope.responseHeadersList.length; x++) {
                var obj = $scope.responseHeadersList[x];
                if (obj.headerName){
                    var pair = obj.headerName + ":" + obj.headerValue;

                    stubToBeSaved.responseHeaders += pair + "||";
                }



            }
            if (stubToBeSaved.responseHeaders)
                stubToBeSaved.responseHeaders = stubToBeSaved.responseHeaders.substring(0,stubToBeSaved.responseHeaders.length-2);

            if (stubToBeSaved.responseHeaders)
                stub.responseHeaders = window.btoa(stubToBeSaved.responseHeaders);

            if (stubToBeSaved.response)
                stub.response = window.btoa(stubToBeSaved.response);

            stub.$save();


        }



    }]);



