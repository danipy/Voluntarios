var appControllers = angular.module('appControllers', ['ngRoute', 'ngResource', 'ngMaterial']); //'infinite-scroll'

appControllers.controller('MainCtrl', function($scope, $timeout) {
	//...
});

appControllers.controller('SidenavCtrl', ['$scope', '$mdSidenav', function($scope, $mdSidenav) {
	$scope.showSidenav = function() {
		$mdSidenav('snLeft').toggle();
	};
}]);

appControllers.controller('EventsHeaderCtrl', ['$scope', function($scope) {
	//...
}]);

appControllers.controller('OngCtrl', ['$scope', '$resource', '$timeout',
	function($scope, $resource, $timeout) {
		$scope.ongEvents = [
		{
			name: "Evento 1",
			description: "But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.",
			date: "29 de febrero del 2015",
			time: "5:00 p.m. UTC",
			address: "Sereno #80, Colinas del Sur C.P. 01430",
			location: "33.92837, 57.30924",
			isLocationShown: false
		},
		{
			name: "Evento 2",
			description: "But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.",
			date: "29 de febrero del 2015",
			time: "5:00 p.m. UTC",
			address: "Sereno #80, Colinas del Sur C.P. 01430",
			location: "33.92837, 57.30924",
			isLocationShown: false
		},
		{
			name: "Evento 3",
			description: "But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.",
			date: "29 de febrero del 2015",
			time: "5:00 p.m. UTC",
			address: "Sereno #80, Colinas del Sur C.P. 01430",
			location: "33.92837, 57.30924",
			isLocationShown: false
		},
		{
			name: "Evento 4",
			description: "But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.",
			date: "29 de febrero del 2015",
			time: "5:00 p.m. UTC",
			address: "Sereno #80, Colinas del Sur C.P. 01430",
			location: "33.92837, 57.30924",
			isLocationShown: false
		},
   ];
}]);

appControllers.controller('EventsCtrl', ['$scope', '$resource', '$timeout', '$mdSidenav',
	function($scope, $resource, $timeout, $mdSidenav) {
	
	var themes = ['blueGreyTheme', 'tealTheme',
	              	'indigoTheme', 'cyanTheme'];
	
	var p = 0, s = 2;
	$scope.events = [];
	$scope.loadMore = function() {
		$scope.isLoadingEvents = true;
		$scope.dynamycTheme = themes[Math.floor(Math.random() * themes.length)];
		console.log($scope.dynamicTheme);
		var Events = $resource("events/content/events/", {page: p, size: s});
		Events.get().$promise.then(function(response) {
			angular.forEach(response.content, function(value, key) {
				$scope.events.push(value);
			});
			$scope.isLoadingEvents = false;
			
			p++;
		});
	};

}]);