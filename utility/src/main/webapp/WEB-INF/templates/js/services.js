var sampleServices = angular.module('sampleServices', [ 'ngResource' ]);

sampleServices.factory('Sample', [ '$resource', function($resource) {
	return $resource('data/abc.json', {}, {
		query : {
			method : 'GET',
			params : {
				loginId : 'abc'
			},
			isArray : true
		}
	});
} ]);