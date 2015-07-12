var sampleCtls = angular.module('sampleCtls', []);

sampleCtls.controller('sample', [ '$scope', 'Sample',
		function($scope, Sample) {
			$scope.xyz = Sample.query();
		} ]);

phonecatControllers.controller('PhoneDetailCtrl', [ '$scope', '$routeParams',
		'Phone', function($scope, $routeParams, Phone) {
			$scope.phone = Phone.get({
				phoneId : $routeParams.phoneId
			}, function(phone) {
				$scope.mainImageUrl = phone.images[0];
			});

			$scope.setImage = function(imageUrl) {
				$scope.mainImageUrl = imageUrl;
			}
		} ]);