var libraryModule = angular.module('libraryApp', ['ngRoute', 'ngCookies']);

libraryModule.config(["$routeProvider", function($routeProvider){
	return $routeProvider.when("/",{
		redirectTo: "/home"
	}).when("/home", {
		templateUrl: "home.html"
	}).when("/authors", {
		templateUrl: "authors.html"
	}).when("/addAuthor", {
		templateUrl: "addauthor.html"
	})
}])

libraryModule.controller('authorCtrl', function($scope, $http, $window){
	$http.get('http://localhost:8080/laithproject/authors').
	success(function(data){
		$scope.authors = data;
	});
	
	$scope.addAuthor = function(){
		var author = {authorName: $scope.author.authorName};
		$http.post('http://localhost:8080/lms/addAuthor', author).
			success(function(data){
				$window.location.href = "#/listAuthor";
		});
	}
	
	
})
