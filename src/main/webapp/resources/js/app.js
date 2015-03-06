var app = angular.module('volApp', ['appControllers']);

app.config(['$mdThemingProvider', function($mdThemingProvider){
	$mdThemingProvider.theme('appTheme')
		.primaryPalette('blue');
	
	$mdThemingProvider.theme('blueGreyTheme')
		.primaryPalette('blue-grey');
	
	$mdThemingProvider.theme('tealTheme')
		.primaryPalette('teal');
	
	$mdThemingProvider.theme('indigoTheme')
		.primaryPalette('indigo');
	
	$mdThemingProvider.theme('cyanTheme')
		.primaryPalette('cyan');
	
	$mdThemingProvider.theme('pinkTheme')
		.primaryPalette('pink');
	
	$mdThemingProvider.theme('deepOrangeTheme')
		.primaryPalette('deep-orange');
	
	$mdThemingProvider.theme('deepPurpleTheme')
		.primaryPalette('deep-purple');
	
	$mdThemingProvider.theme('amberTheme')
		.primaryPalette('amber');
	
	$mdThemingProvider.theme('greenTheme')
		.primaryPalette('green');
	
	$mdThemingProvider.setDefaultTheme('appTheme');
}]);

app.directive('volSidenav', function() {
	return {
		restrict: 'E',
		templateUrl: 'partials/sidenav.html',
		controller: 'SidenavCtrl'
	};
});

app.directive('volHeader', function() {
	return {
		restrict: 'E',
		templateUrl: 'partials/events-header.html',
		controller: 'EventsHeaderCtrl'
	};
});

app.directive('volEvents', function() {
	return {
		restrict: 'E',
		templateUrl: 'partials/events-list.html',
		controller: 'EventsCtrl'
	};
});

app.directive('volFooter', function() {
	return {
		restrict: 'E',
		templateUrl: 'partials/footer.html'
	};
});

//test only
app.directive('volEventsGrid', function() {
	return {
		restrict: 'E',
		templateUrl: 'partials/events-grid-list.html',
		controller: 'EventsCtrl'
	};
});

//app.config(['$routeProvider', function($routeProvider) {
//	$routeProvider
//		.when('/events', {
//			templateUrl: 'partials/events-list.html',
//			controller: 'EventsCtrl'
//		})
//		.otherwise({
//			redirectTo: 'events'
//		});
//}]);