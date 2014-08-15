var app = angular.module("TrustFramework", ['ui.bootstrap']);

app.controller('TrustCtrl', function($scope, $http){
    $scope.date = new Date();
    $scope.cards = {};
    $scope.hello = function(){ return "hello"};
    $scope.error = "";
    $scope.getCard = function(){
        $http({
            url: './card',
            method: "GET"
        }).success(function(data, status, headers, config){
            $scope.cards = data;
        }).error(function(data, status, headers, config){
            $scope.error = data;
        })
    };
    
    
    $scope.selectCard = function(card){
        $scope.selectedCard = card;
    }

});