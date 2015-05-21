urlContext = "/Voluntarios";

var appControllers = angular.module('appControllers',
		['ngRoute', 'ngResource', 'ngAnimate', 'ngMaterial']); //'infinite-scroll'

appControllers.controller('MainCtrl', function($scope, $timeout) {
	//...
});

appControllers.controller('SidenavCtrl', ['$scope', '$mdSidenav', function($scope, $mdSidenav) {
	console.log("sidenav ctrl")
	
	$scope.signInUrl = "#/login";
	$scope.registerUrl = "#/register";
	$scope.ongsUrl = "#/ongs";
	$scope.eventsUrl = "#/events";
	$scope.ongNewUrl = "#/ongs/new"
}]);

appControllers.controller('EventsHeaderCtrl', ['$scope', function($scope) {
	//...
}]);

appControllers.controller('NewOngCtrl', ['$scope', '$resource', '$timeout', '$filter', '$routeParams', '$mdDialog',
	function($scope, $resource, $timeout, $filter, $routeParams, $mdDialog) {
	console.log("NewOngCtr");
	var Ong = $resource("/Voluntarios/ongs/:ong", {ong: "@ong"});
	console.log(Ong);
	
	$scope.createOng = function(ong) {
		console.log(ong)
		console.log("asdas");
	}
}]);

appControllers.controller('OngCtrl',
		['$rootScope', '$scope', '$resource', '$timeout', '$filter', '$routeParams', '$mdDialog',
	function($rootScope, $scope, $resource, $timeout, $filter, $routeParams, $mdDialog) {
			
	$scope.ongResource = {};
	$scope.ongEvents = [];
	$scope.ongVolunteers = [];
	
	var id = $routeParams.id;
	var urlOng = urlContext + "/ongs/" + id;
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
	  
	$scope.save = function(ong) {
		var ongObj = new Ong();
		console.log(ongObj);
	};
	
	//temp
	var randomId = Math.floor(Math.random() * 10);
	$scope.randomPhoto = "https://randomuser.me/api/portraits/thumb/lego/"+randomId+".jpg";
	
}]);

appControllers.controller('EventCtrl',
		['$rootScope', '$scope', '$resource', '$timeout', '$mdSidenav', '$route', '$routeParams', '$location', '$filter',
		 function($rootScope, $scope, $resource, $timeout, $mdSidenav, $route, $routeParams, $location, $filter) {
		console.log("Event Ctrl");
		
		var id = $routeParams.id;
		var urlEvent = "/Voluntarios/events/" + id;
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
		['$rootScope', '$scope', '$resource', '$timeout', '$filter', '$routeParams',
		 function($rootScope, $scope, $resource, $timeout, $filter, $routeParams) {
			
			var id = $routeParams.id;
			var urlVolunteers = urlContext + "/volunteers",
				urlVolunteer = urlVolunteers + "/" + id,
				urlVolEvents = urlVolunteer + "/events",
				urlVolOngs = urlVolunteer + "/ongs";
			
			$scope.volunteerResource = {};
			$scope.volunteerEvents = [];
			$scope.volunteerOngs = [];
			
			var Volunteer = $resource(urlVolunteer);
			var VolunteerEvents = $resource(urlVolEvents);
			var VolunteerOngs = $resource(urlVolOngs);
			
			$scope.volunteerResource = Volunteer.get();
			
			VolunteerEvents.get().$promise.then(function(response) {
				angular.forEach(response.content, function(eventResource, key) {
					$scope.volunteerEvents.push(eventResource);
				});
			});
			
			VolunteerOngs.get().$promise.then(function(response) {
				angular.forEach(response.content, function(ongResource) {
					$scope.volunteerOngs.push(ongResource);
				});
			});
			
			//temp
			var randomId = Math.floor(Math.random() * 10);
			$scope.randomPhotoMed = "https://randomuser.me/api/portraits/med/lego/"+randomId+".jpg";
	
}]);

appControllers.controller('LoginCtrl',
		['$rootScope', '$scope', '$http', '$mdToast', '$mdSidenav', '$location',
		 function($rootScope, $scope, $http, $mdToast, $mdSidenav, $location) {
			console.log("LoginCtrl")
			$rootScope.isAuth = false;
			
			$scope.user = {};
			
			var authenticate = function(credentials, callback) {
				var username = credentials ? credentials.username : "";
				var headers = credentials ? {authorization: "Basic " 
					+ btoa(credentials.username + ":" + credentials.password)
				} : {};
			
				$http.get('user', {headers: headers}).success(function(data) {
					if(data.name) {
						$rootScope.authenticated = true;
						$scope.user.username = data.name
					} else {
						$rootScope.authenticated = false;
						$scope.user = {};
					}
					callback && callback();
				}).error(function() {
					$rootScope.authenticated = false;
					callback && callback();
				});
			};
			
			authenticate();
			$scope.credentials = {};
			$scope.login = function() {
				authenticate($scope.credentials, function() {
					if($rootScope.authenticated) {
						$scope.error = false;
						$scope.showWelcomeToast();
//						$location.path("/")

					} else {
						$scope.error = true;
						$scope.showErrorToast();
					}
				});
			};
			
			$scope.logout = function() {
				$http.post('logout', {}).success(function() {
					$rootScope.authenticated = false;
//					$location.path("/");
				}).error(function(data) {
					$rootScope.authenticated = false;
				});
			}
			
			$scope.showErrorToast = function() {
				var customToast = {
					template: 
						'<md-toast class="md-capsule">'
						+	'Hubo un problema con la autenticaci&oacute;n, intente de nuevo'
						+'</md-toast>',
					hideDelay: 3000,
					position: 'top right',
					parent: document.getElementById("login")
				};
				
				$mdToast.show(customToast);
			};
			
			$scope.showWelcomeToast = function() {
				var customToast = {
					template: 
						'<md-toast class="md-capsule" layout="row" layout-align="space-around">'
						+	'Bienvenido '
						+	'<img src="'+ $scope.randomPhotoThumb +'" class="face-toolbar"/>'
						+	$scope.user.username
						+'</md-toast>',
					hideDelay: 3000,
					position: 'top right',
					parent: angular.element(document.getElementById('login'))
				};
				
				$mdToast.show(customToast);
			};
			
			$scope.showSidenav = function() {
				$mdSidenav('snLeft').toggle();
			};
			
			//temp
			$scope.randomPhotoThumb = "https://randomuser.me/api/portraits/thumb/lego/"+Math.floor(Math.random() * 10)+".jpg";
}]);

function randomTheme() {
	var themes = ['blueGreyTheme', 'tealTheme', 'indigoTheme', 'cyanTheme',
	              'pinkTheme', 'purpleTheme', 'deepOrangeTheme',
	              'deepPurpleTheme', 'amberTheme', 'greenTheme'];
	
	return themes[Math.floor(Math.random() * themes.length)];
}