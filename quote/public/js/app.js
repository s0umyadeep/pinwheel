'use strict';

angular.module('quote', [ 'ngCookies' ]).controller('quoteController',
		[ '$cookies', '$scope', function($cookies, $scope) {
			var favoriteCookie = $cookies.get('myFavorite');
			if (favoriteCookie == null) {
				$scope.check = "Not set";
			} else {
				$scope.check = favoriteCookie;
			}
			// Setting a cookie
			$cookies.put('myFavorite', 'oatmeal');
		} ]);
