'use strict';

angular.module('quote', [ 'ngCookies' ]).controller('quoteController',
		[ '$cookies', '$scope', '$http', function($cookies, $scope, $http) {

			var counter = $cookies.get('counter');
			if (counter == null) {
				$cookies.put('counter', 1);
			} else {
				$cookies.put('counter', ++counter);
			}
			if (counter % 7 != 0) {
				$http({
					method : 'GET',
					url : '/quote'
				}).then(function successCallback(response) {
					$scope.qdata = response.data;
				}, function errorCallback(response) {
				});
			} else{
				$scope.qdata = {"author":"Al Gore","topic":"Politics","quoteText":"No you did not"};
			}

		} ]);
