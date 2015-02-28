var appControllers = angular.module('appControllers', ['ngRoute', 'ngResource', 'ngMaterial']); //'infinite-scroll'

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
		['$scope', '$resource', '$timeout', '$filter', '$mdDialog',
	function($scope, $resource, $timeout, $filter, $mdDialog) {
	
	$scope.ongResource = {};
	$scope.ongEvents = [];
	$scope.ongVolunteers = [];
	
	var urlOng = window.location.pathname;
	var urlOngEvents = urlOng + "/events";
	var urlOngVolunteers = urlOng + "/volunteers"
	
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
	
	OngVolunteers.get().$promise.then(function(response) {
		angular.forEach(response.content, function(volunteerResource, key) {
			$scope.ongVolunteers.push(volunteerResource);
		});
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

appControllers.controller('EventsCtrl',
		['$scope', '$resource', '$timeout', '$mdSidenav', '$location', '$filter',
		 function($scope, $resource, $timeout, $mdSidenav, $location, $filter) {
	
	var urlEvents = window.location.pathname;
	var Events = $resource(urlEvents);
	var p = 0, s = 5;
	
	$scope.events = [];
	$scope.loadMore = function() {
		$scope.isLoadingEvents = true;
		$scope.dynamicTheme = randomTheme();
		console.log(p);
		Events.get({page: p, size: s}).$promise.then(function(response) {
			console.log(response);
			angular.forEach(response.content, function(eventResource, key) {
				$scope.events.push(eventResource);
			});
			$scope.isLoadingEvents = false;
			p++;
		});
	};
	
	$scope.viewEvent = function(links) {
		var urlEvent = $filter('filter')(links, 'self', true)[0].href;
		window.location.href = urlEvent;
	}
	
	$scope.loadMore();

}]);

function randomTheme() {
	var themes = ['blueGreyTheme', 'tealTheme', 'indigoTheme',
	              'cyanTheme', 'pinkTheme', 'deepOrangeTheme',
	              'deepPurpleTheme', 'amberTheme', 'greenTheme'];
	
	return themes[Math.floor(Math.random() * themes.length)];
}