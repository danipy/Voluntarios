var app = angular.module('volApp', ['appControllers']);

app.config(['$mdThemingProvider', function($mdThemingProvider){
	$mdThemingProvider.theme('appTheme')
		.primaryPalette('blue')
		.accentPalette('pink');
	
	$mdThemingProvider.theme('blueGreyTheme')
		.primaryPalette('blue-grey')
		.accentPalette('blue');
	
	$mdThemingProvider.theme('tealTheme')
		.primaryPalette('teal')
		.accentPalette('indigo');
	
	$mdThemingProvider.theme('indigoTheme')
		.primaryPalette('indigo')
		.accentPalette('pink');
	
	$mdThemingProvider.theme('cyanTheme')
		.primaryPalette('cyan')
		.accentPalette('amber');
	
	$mdThemingProvider.theme('pinkTheme')
		.primaryPalette('pink')
		.accentPalette('purple');
	
	$mdThemingProvider.theme('purpleTheme')
		.primaryPalette('purple')
		.accentPalette('deep-orange');
	
	$mdThemingProvider.theme('deepOrangeTheme')
		.primaryPalette('deep-orange')
		.accentPalette('orange');
	
	$mdThemingProvider.theme('deepPurpleTheme')
		.primaryPalette('deep-purple')
		.accentPalette('orange');
	
	$mdThemingProvider.theme('amberTheme')
		.primaryPalette('amber')
		.accentPalette('teal');
	
	$mdThemingProvider.theme('greenTheme')
		.primaryPalette('green')
		.accentPalette('amber');
	
	$mdThemingProvider.setDefaultTheme('appTheme');
}]);

app.directive('volSidenav', function() {
	return {
		restrict: 'E',
		templateUrl: '/Voluntarios/partials/sidenav.html',
		controller: 'SidenavCtrl'
	};
});

app.directive('volHeader', function() {
	return {
		restrict: 'E',
		templateUrl: '/Voluntarios/partials/events-header.html',
		controller: 'EventsHeaderCtrl'
	};
});

app.directive('volEvents', function() {
	return {
		restrict: 'E',
		scope: { events: '=events' },
		templateUrl: '/Voluntarios/partials/events-list.html'
	};
});

app.directive('volEventsMini', function() {
	return {
		restrict: 'E',
		scope: { events: '=events' },
		templateUrl: '/Voluntarios/partials/events-list-mini.html'
	};
});

app.directive('volFooter', function() {
	return {
		restrict: 'E',
		templateUrl: '/Voluntarios/partials/footer.html'
	};
});

//test only
app.directive('volEventsGrid', function() {
	return {
		restrict: 'E',
		templateUrl: '/Voluntarios/partials/events-grid-list.html',
		controller: 'EventCtrl'
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