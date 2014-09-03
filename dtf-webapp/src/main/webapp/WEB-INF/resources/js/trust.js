var trustFrameworkApp = angular.module("trustFrameworkApp", ["ngRoute", "trustControllers", "ui.bootstrap"]);

trustFrameworkApp.config(function($routeProvider) {
    $routeProvider
      .when('/instance-builder',
      {
    	  templateUrl: "views/instance-builder.html",
    	  controller: "instanceCtrl"
      })
      .when('/card/:id',
      {
        templateUrl: "views/card.html",
        controller: "trustCtrl"
      })
});

var trustControllers = angular.module('trustControllers', []);

trustControllers.controller('instanceCtrl', ['$scope', '$http',
                                             function($scope, $http) {
    $scope.date = new Date();
    $scope.cards = [];
    $scope.instanceCards = [];
    $scope.instance = [];
    $scope.error = "";
	$http.get('./card').success(function(data) {
		$scope.cards = data;
		$scope.instanceCards.push(data[0]); // TODO make this intelligently choose root cards
		$scope.addJsonInstanceCard(data[0], "");
	}).error(function(data) {
		$scope.error = data;
	});
	
    $scope.postInstance = function(){
    	$http({
    		url: './instance',
    		method: 'POST',
    		data: $scope.instance,
    		headers: {
    			'Content-Type': 'application/json'
    		}
    	}).success(function(data){
    		$scope.instance = data;
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
    };
    
    $scope.selectCard = function(card){
        $scope.selectedCard = card;
    };
    

    $scope.getJsonInstanceCard = function(card){
    	if (!card) {
    		return ""
    	}
    	for (jic in $scope.instance) {
    		if (jic.id === card.id) {
    			return jic;
    		} else {
    			return ""; //not found
    		}
    	}
    };
    
    $scope.addJsonInstanceCard = function(card, parent) {
    	 var jic = {};
    	 var parentjic = $scope.getJsonInstanceCard(parent);
    	 if (parentjic) {
    		 jic = {"id":card.id, "parent": parentjic.id, "children":[]};
    		 $scope.getJsonInstanceCard(parent).children.push(card.id);
    	 }
    	 $scope.instance.push(jic);
    };
    
    $scope.businessTxt = function(card){
    	card.currentTxt = card.businessTxt;
    };
    
    $scope.legalTxt = function(card){
    	card.currentTxt = card.legalTxt;
    };
    
    $scope.technicalTxt = function(card){
    	card.currentTxt = card.technicalTxt;
    };
}]);

// returns index of a tag in an array of tag objects, or -1 if not found
function tagIndexOf(tags, searchTag) {
    for(var i = 0; i < tags.length; i++) {
        if (tags[i].id === searchTag.id) return i;
    }
    return -1;
};