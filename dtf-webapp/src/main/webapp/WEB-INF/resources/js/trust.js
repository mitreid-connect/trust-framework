var trustFrameworkApp = angular.module("trustFrameworkApp", [ "ngRoute", "trustControllers", "ui.bootstrap" ]);

trustFrameworkApp.config(function($routeProvider) {
	$routeProvider.when('/instance-builder', {
		templateUrl : "views/instance-builder.html",
		controller : "instanceCtrl"
	}).when('/card', {
		templateUrl : "views/all-cards.html",
		controller : "instanceCtrl"
	}).when('/card/:cardId', {
		templateUrl : 'views/card.html',
		controller : "cardCtrl"
	}).otherwise({
		template : 'Move along, nothing to see here.'
	})
});

trustFrameworkApp.factory('trustServices', function() {
	var date = new Date();
	var cards = [];
	var error = "";

	return {
		// returns the set of cards that satisfy the input dependency
		getCandidateCards : function(cards, dependency) {
			var candidates = [];
			for (i = 0; i < cards.length; i++) {
				var currentCard = cards[i];
				var isSuperset = dependency.tags.every(function(val) {
					return tagIndexOf(currentCard.providesTags, val) >= 0;
				});
				if (isSuperset) {
					candidates.push(cards[i]);
				}
			}
			return candidates;
		},

		selectTxt : {
			businessTxt : function(card) {
				card.currentTxt = card.businessTxt;
			},

			legalTxt : function(card) {
				card.currentTxt = card.legalTxt;
			},

			technicalTxt : function(card) {
				card.currentTxt = card.technicalTxt;
			}
		}
	}
});

var trustControllers = angular.module('trustControllers', []);

trustControllers.controller('cardCtrl', [ '$scope', 'trustServices', '$http', '$routeParams',
		function($scope, trustServices, $http, $routeParams) {
			$http.get('./card/' + $routeParams.cardId).success(function(data) {
				$scope.card = data
			}).error(function(data) {
				$scope.error = data;
			});
			

			$scope.getCandidateCards = function(dependency) {
				return trustServices.getCandidateCards($scope.cards, dependency);
			};

			$scope.selectTxt = trustServices.selectTxt;

			
		} ]);

trustControllers.controller('instanceCtrl', [ '$scope', 'trustServices', '$http',
		function($scope, trustServices, $http) {

			$scope.cards = [];
			$scope.instanceCards = [];
			$scope.instance = [];

			$http.get('./card').success(function(data) {
				$scope.cards = data;
				$scope.instanceCards.push(data[0]); // TODO make this
				// intelligently choose root
				// cards
				$scope.addJsonInstanceCard(data[0], "");
			}).error(function(data) {
				$scope.error = data;
			});

			$scope.getCandidateCards = function(dependency) {
				return trustServices.getCandidateCards($scope.cards, dependency);
			};

			$scope.selectTxt = trustServices.selectTxt;

			$scope.postInstance = function() {
				$http({
					url : './instance',
					method : 'POST',
					data : $scope.instance,
					headers : {
						'Content-Type' : 'application/json'
					}
				}).success(function(data) {
					$scope.instance = data;
				})
			};

			$scope.getJsonInstanceCard = function(card) {
				if (!card) {
					return ""
				}
				for (jic in $scope.instance) {
					if (jic.id === card.id) {
						return jic;
					} else {
						return ""; // not found
					}
				}
			};

			$scope.addJsonInstanceCard = function(card, parent) {
				var jic = {};
				var parentjic = $scope.getJsonInstanceCard(parent);
				if (parentjic) {
					jic = {
						"id" : card.id,
						"parent" : parentjic.id,
						"children" : []
					};
					$scope.getJsonInstanceCard(parent).children.push(card.id);
				}
				$scope.instance.push(jic);
			};

		} ]);

// returns index of a tag in an array of tag objects, or -1 if not found
function tagIndexOf(tags, searchTag) {
	for (var i = 0; i < tags.length; i++) {
		if (tags[i].id === searchTag.id)
			return i;
	}
	return -1;
};