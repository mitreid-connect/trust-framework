var app = angular.module("TrustFramework", ['ui.bootstrap']);

app.controller('TrustCtrl', function($scope, $http){
    $scope.date = new Date();
    $scope.cards = {};
    $scope.error = "";
    
    $scope.getCards = function(){
        $http({
            url: './card',
            method: "GET"
        }).success(function(data, status, headers, config){
            $scope.cards = data;
        }).error(function(data, status, headers, config){
            $scope.error = data;
        })
    };
    
    $scope.getCandidateCards = function(dependency){
    	// TODO write this function
    }
    
    $scope.selectCard = function(card){
        $scope.selectedCard = card;
    }
    
    $scope.businessTxt = function(card){
    	card.currentTxt = card.businessTxt;
    };
    
    $scope.legalTxt = function(card){
    	card.currentTxt = card.legalTxt;
    };
    
    $scope.technicalTxt = function(card){
    	card.currentTxt = card.technicalTxt;
    };
    
    $scope.getCards();

});