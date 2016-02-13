'use strict';

angular.module('quote', [ 'ngCookies' ]).controller('quoteController',
		[ '$cookies', '$scope', '$http', '$window', '$location', function($cookies, $scope, $http, $window) {
			
			var counter = $cookies.get('counter');
			if (counter == null) {
				$cookies.put('counter', 8);
			} else {
				$cookies.put('counter', ++counter);
			}
			console.log(counter);
			if (counter % 7 != 0) {
				$scope.title = "Quote of The Day";
				$scope.buttonName = "Refresh";
				$scope.reloadWindow = function() {
					   $window.location.reload();
				};
				$scope.buttonStyle = "btn btn-lg btn-primary";

				$http({
					method : 'GET',
					url : '/quote'
				}).then(function successCallback(response) {
					//$scope.qdata = response.data;
					$scope.text = response.data.quoteText+" - "+response.data.author;
					$scope.topic = "Topics: " +response.data.topic;
				}, function errorCallback(response) {
				});
			} else{
				$cookies.put('counter', 7);
				//$scope.qdata = {"author":"Al Gore","topic":"Politics","quoteText":"No you did not"};
				$scope.title = "Congratulations! You have just won $1,000,000. Please click here to redeem your prize.";
				$scope.text = "";
				$scope.topic = "";
				$scope.buttonName = "Redeem";
				$scope.reloadWindow = function() {
					$window.location.href="http://www.performancecentre.com/";
				}; 
				$scope.buttonStyle = "btn btn-lg btn-success";
			}

		} ]);
