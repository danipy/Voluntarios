var app = angular.module('volApp', ['appControllers']);

app.config(['$httpProvider', '$routeProvider', '$locationProvider', '$mdThemingProvider', 
            function($httpProvider, $routeProvider, $locationProvider, $mdThemingProvider) {
	
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
	
	$routeProvider
	.when('/', {
		redirectTo: 'events'
	})
	.when('/login', {
		templateUrl: 'partials/login.html',
	})
	.when('/events', {
		templateUrl: 'partials/events.html',
		controller: 'EventCtrl'
	})
	.when('/events/:id', {
		templateUrl: 'partials/event.html',
		controller: 'EventCtrl'
	})
	.when('/ongs/:id', {
		templateUrl: 'partials/ong.html',
		controller: 'OngCtrl'
	})
	.when('/new/ong', {
		templateUrl: 'partials/ong-new.html',
		controller: 'NewOngCtrl'
	})
	.when('/volunteers/:id', {
		templateUrl: 'partials/volunteer.html',
		controller: 'VolunteerCtrl'
	})
	.otherwise({
		redirectTo: 'events'
	});
	
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
	
	$mdThemingProvider.theme('errorTheme')
		.primaryPalette('red')
	
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
		controller: 'LoginCtrl'
	};
});

app.directive('volEvents', function() {
	return {
		restrict: 'E',
		scope: { events: '=events' },
		templateUrl: 'partials/events-list.html'
	};
});

app.directive('volEventsMini', function() {
	return {
		restrict: 'E',
		scope: { events: '=' },
		templateUrl: 'partials/events-list-mini.html'
	};
});

app.directive('volOngsList', function() {
	return {
		restrict: 'E',
		scope: { ongs: '=' },
		templateUrl: 'partials/ongs-list.html'
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
		scope: { events: '=events' },
		templateUrl: 'partials/events-grid-list.html'
	};
});