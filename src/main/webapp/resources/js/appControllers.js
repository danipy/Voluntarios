var appControllers = angular.module('appControllers', ['ngRoute', 'ngResource', 'ngAnimate', 'ngMaterial']); //'infinite-scroll'

appControllers.controller('MainCtrl', function($scope, $timeout) {
	//...
});

appControllers.controller('SidenavCtrl', ['$scope', '$mdSidenav', function($scope, $mdSidenav) {
	
	var contextUrl = "/Voluntarios";
	
	$scope.signInUrl = "/";
	$scope.registerUrl = contextUrl + "/register";
	$scope.ongsUrl = contextUrl + "/ongs";
	$scope.eventsUrl = contextUrl + "/events";
	
	$scope.showSidenav = function() {
		$mdSidenav('snLeft').toggle();
	};
}]);

appControllers.controller('EventsHeaderCtrl', ['$scope', function($scope) {
	//...
}]);

appControllers.controller('OngCtrl',
		['$rootScope', '$scope', '$resource', '$timeout', '$filter', '$mdDialog',
	function($rootScope, $scope, $resource, $timeout, $filter, $mdDialog) {
			
	$scope.ongResource = {};
	$scope.ongEvents = [];
	$scope.ongVolunteers = [];
	
	var urlOng = window.location.pathname;
	var urlOngEvents = urlOng + "/events";
	var urlOngVolunteers = urlOng + "/volunteers"
	var p=0, s=5;
	
	var Ong = $resource(urlOng);	
	var OngEvents = $resource(urlOngEvents);
	var OngVolunteers = $resource(urlOngVolunteers);
	
	$scope.ongResource = Ong.get();
	
	OngEvents.get().$promise.then(function(response) {
		angular.forEach(response.content, function(eventResource, key) {
			$scope.ongEvents.push(eventResource);
		});
	});
	
	OngEvents.get().$promise.then(function(response) {
		angular.forEach(response.content, function(eventResource, key) {
			$scope.ongEvents.push(eventResource);
		});
	});
	
	OngVolunteers.get({page: p, size: s}).$promise.then(function(response) {
		angular.forEach(response.content, function(volunteerResource, key) {
			$scope.ongVolunteers.push(volunteerResource);
		});
		p++;
	});
	
	$scope.showConfirm = function(ev) {
	    var confirm = $mdDialog.confirm()
	      .title('¿Quieres unirte a esta causa?')
	      .content('Tu ayuda es muy apreciada')
	      .ariaLabel('Enviar solicitud')
	      .ok('Claro que si!')
	      .cancel('No, lo siento')
	      .disableParentScroll(false)
	      .targetEvent(ev);
	    console.log(confirm);
	    $mdDialog.show(confirm).then(function() {
	      $scope.alert = 'You decided to get rid of your debt.';
	    }, function() {
	      $scope.alert = 'You decided to keep your debt.';
	    });
	  };
	
	//temp
	var randomId = Math.floor(Math.random() * 10);
	$scope.randomPhoto = "https://randomuser.me/api/portraits/thumb/lego/"+randomId+".jpg";
	
}]);

appControllers.controller('EventCtrl',
		['$rootScope', '$scope', '$resource', '$timeout', '$mdSidenav', '$location', '$filter',
		 function($rootScope, $scope, $resource, $timeout, $mdSidenav, $location, $filter) {
	
			var urlEvent = window.location.pathname;
	var urlEvents = "/Voluntarios/events",
		urlEventVolunteers = urlEvent + "/volunteers"
	var p = 0, s = 5;
	
	var Event = $resource(urlEvent);
	var Events = $resource(urlEvents);
	var EventVolunteers = $resource(urlEventVolunteers);
	
	$scope.event = {};
	$scope.events = [];
	$scope.eventVolunteers = [];
	
	$scope.eventResource = Event.get();
	
	$scope.loadMore = function() {
		$scope.isLoadingEvents = true;
		$scope.dynamicTheme = randomTheme();
		Events.get({page: p, size: s}).$promise.then(function(response) {
			angular.forEach(response.content, function(eventResource, key) {
				$scope.events.push(eventResource);
			});
			$scope.isLoadingEvents = false;
			p++;
		});
	};
	
	EventVolunteers.get().$promise.then(function(response) {
		angular.forEach(response.content, function(eventResource, key) {
			$scope.eventVolunteers.push(eventResource);
		});
	});
	
	//temp
	var randomId = Math.floor(Math.random() * 10);
	$scope.randomPhoto = "https://randomuser.me/api/portraits/med/lego/"+randomId+".jpg";
	
	$scope.loadMore();

}]);

appControllers.controller('VolunteerCtrl',
		['$rootScope', '$scope', '$resource', '$timeout', '$filter',
		 function($rootScope, $scope, $resource, $timeout, $filter) {
			
			var urlVolunteers = "/Voluntarios/volunteers",
				urlVolunteer = window.location.pathname,
				urlVolEvents = urlVolunteer + "/events",
				urlVolOngs = urlVolunteer + "/ongs";
			
			$scope.volunteerResource = {};
			$scope.volunteerEvents = [];
			$scope.volunteerOngs = [];
			
			var Volunteer = $resource(urlVolunteer);
			var VolunteerEvents = $resource(urlVolEvents);
			
			$scope.volunteerResource = Volunteer.get();
			
			VolunteerEvents.get().$promise.then(function(response) {
				angular.forEach(response.content, function(eventResource, key) {
					$scope.volunteerEvents.push(eventResource);
				});
			});
			
			//temp
			var randomId = Math.floor(Math.random() * 10);
			$scope.randomPhoto = "https://randomuser.me/api/portraits/med/lego/"+randomId+".jpg";
	
}]);

appControllers.controller('LoginCtrl',
		['$rootScope', '$scope', '$http', function($rootScope, $scope, $http) {
			$rootScope.isAuth = false;
			
			$scope.login = function() {
				$rootScope.isAuth = true;
			};
}]);

function randomTheme() {
	var themes = ['blueGreyTheme', 'tealTheme', 'indigoTheme', 'cyanTheme',
	              'pinkTheme', 'purpleTheme', 'deepOrangeTheme',
	              'deepPurpleTheme', 'amberTheme', 'greenTheme'];
	
	return themes[Math.floor(Math.random() * themes.length)];
}