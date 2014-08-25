var app = angular.module("trustFramework", ['ui.bootstrap']);

app.controller('trustCtrl', function($scope, $http){
    $scope.date = new Date();
    $scope.cards = {};
    $scope.error = "";
    
    // gets all cards from the server
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
    
    // returns the set of cards that satisfy the input dependency
    $scope.getCandidateCards = function(dependency){
    	var candidates = [];
    	for (i = 0; i < $scope.cards.length; i++) {
    		var currentCard = $scope.cards[i];
    		var isSuperset = dependency.tags.every(function(val) { 
    			return tagIndexOf(currentCard.providesTags, val) >= 0;
    			}
    		);
    		if (isSuperset) {
    			candidates.push($scope.cards[i]);
    		}
    	}
    	return candidates;
    }
    
    // returns index of a tag in an array of tag objects, or -1 if not found
    function tagIndexOf(tags, searchTag) {
        for(var i = 0; i < tags.length; i++) {
            if (tags[i].id === searchTag.id) return i;
        }
        return -1;
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