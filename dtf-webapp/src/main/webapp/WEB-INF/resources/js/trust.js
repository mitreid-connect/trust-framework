var trustFrameworkApp = angular.module('trustFrameworkApp', [ 'ngRoute', 'customControl', 'trustControllers', 'ui.bootstrap' ]);

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



angular.module('customControl', ['ngSanitize']).
  directive('contenteditable', ['$sce', function($sce) {
    return {
      restrict: 'A', // only activate on element attribute
      require: '?ngModel', // get a hold of NgModelController
      link: function(scope, element, attrs, ngModel) {
        if (!ngModel) return; // do nothing if no ng-model

        // Specify how UI should be updated
        ngModel.$render = function() {
          element.html($sce.getTrustedHtml(ngModel.$viewValue || ''));
        };

        // Listen for change events to enable binding
        element.on('blur keyup change', function() {
          scope.$apply(read);
        });
        read(); // initialize

        // Write data to the model
        function read() {
          var html = element.html();
          // When we clear the content editable the browser leaves a <br> behind
          // If strip-br attribute is provided then we strip this out
          if ( attrs.stripBr && html == '<br>' ) {
            html = '';
          }
          ngModel.$setViewValue(html);
        }
      }
    };
  }]);



trustFrameworkApp.factory('trustServices', function() {
	var date = new Date();
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
				card.businessSelected = true;
				card.legalSelected = false;
				card.technicalSelected = false;
			},

			legalTxt : function(card) {
				card.legalSelected = true;
				card.technicalSelected = false;
				card.businessSelected = false;
			},

			technicalTxt : function(card) {
				card.technicalSelected = true;
				card.legalSelected = false;
				card.businessSelected = false;
			}
		}
	}
});

var trustControllers = angular.module('trustControllers', []);

trustControllers.controller('cardCtrl', [ '$scope', 'trustServices', '$http', '$routeParams',
		function($scope, trustServices, $http, $routeParams) {
			$http.get('./card/' + $routeParams.cardId).success(function(data) {
				$scope.card = data;
				$scope.card.businessSelected = true;
			}).error(function(data) {
				$scope.error = data;
			});
			

			$scope.getCandidateCards = function(dependency) {
				return trustServices.getCandidateCards($scope.cards, dependency);
			};

			$scope.selectTxt = trustServices.selectTxt;

			$scope.updateCard = function() {
				$http({
					url : './card/' + $routeParams.cardId,
					method : 'PUT',
					data : $scope.card,
					headers : {
						'Content-Type' : 'application/json'
					}
				}).success(function(data) {
					$scope.card = data;
				})
			};
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