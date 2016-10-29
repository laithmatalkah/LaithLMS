var libraryModule = angular.module('libraryApp', ['ngRoute', 'ngCookies', 'ui.bootstrap.modal']);

libraryModule.service("messageCreate",function(){

	this.message=function(){return "Record created successfully";}
});
libraryModule.config(["$routeProvider", function($routeProvider){
	return $routeProvider.when("/",{
		redirectTo: "/home"
	}).when("/home", {
		templateUrl: "home.html"
	}).when("/viewAuthors", {
		templateUrl: "authors.html"
	}).when("/addAuthor", {
		templateUrl: "authors.html"
	}).when("/viewBorrowers", {
		templateUrl: "borrowers.html"
	}).when("/addBorrowers", {
		templateUrl: "borrowers.html"
	}).when("/viewPublishers", {
		templateUrl: "publishers.html"
	}).when("/viewGenres", {
		templateUrl: "genres.html"
	}).when("/viewBranches", {
		templateUrl: "branches.html"
	}).when("/viewBooks", {
		templateUrl: "books.html"
	}).when("/editAuthor", {
		templateUrl: "authors.html"
	})
}])

libraryModule.controller('authorCtrl', function($scope, $http, $window){
	$http.get('http://localhost:8080/laithproject/viewAuthors').
	success(function(data){
		$scope.authors = data;
	});

	$scope.addAuthor = function(){
		var author = {authorName: $scope.author.authorName};
		$http.post('http://localhost:8080/laithproject/addAuthor', author).
		success(function(){
			$http.get('http://localhost:8080/laithproject/viewAuthors').
			success(function(data){
				$scope.authors = data;
			});

		});
	}
	$scope.preEditAuthor=function(authorName, authorId){
		$scope.authorName = authorName;
		$scope.authorId = authorId;
		$scope.auEditModal=true;
	}

	$scope.editAuthor = function(authorName, authorId){
		var author = {authorName: authorName,
				authorId: authorId};
		$http.put('http://localhost:8080/laithproject/editAuthor',author).
		success(function(){
			$scope.auEditModal = false;
			$http.get('http://localhost:8080/laithproject/viewAuthors').
			success(function(data){
				$scope.authors = data;
			});
		})}
	$scope.closeAuEdit = function(){
		$scope.auEditModal = false;
	}
	
	
	$scope.preDeleteAuthor=function(authorName, authorId){
		$scope.authorId = authorId;
		$scope.authorName = authorName;
		$scope.auDeleteModal=true;
	}
	$scope.deleteAuthor = function(authorName, authorId){
		var author = {authorName: authorName,
				authorId: authorId};
		$http.put('http://localhost:8080/laithproject/delAuthor',author).
		success(function(){
			$scope.auDeleteModal = false;
			$http.get('http://localhost:8080/laithproject/viewAuthors').
			success(function(data){
				$scope.authors = data;
			});
		})}
	
	$scope.closeAuDelete = function(){
		$scope.auDeleteModal = false;
	}
	
})

libraryModule.controller('borroCtrl', function($scope, $http, $window){
	$http.get('http://localhost:8080/laithproject/viewBorrowers').
	success(function(data){
		$scope.borrowers = data;
	});

	$scope.addBorrower = function(){
		var borrower = {
				cardNo:$scope.borrower.cardNo,
				borroName: $scope.borrower.borroName,
				borroAddress:$scope.borrower.borroAddress,
				borroPhone :$scope.borrower.borroPhone
				};
		$http.post('http://localhost:8080/laithproject/addBorrower', borrower).
		success(function(data){
			$http.get('http://localhost:8080/laithproject/viewBorrowers').
			success(function(data){
				$scope.borrowers = data;
			});
		});
	}
	
	$scope.preEditBorrower=function(cardNo,borroName, borroAddress,borroPhone){
		$scope.cardNo = cardNo;
		$scope.borroName = borroName;
		$scope.borroAddress = borroAddress;
		$scope.borroPhone=borroPhone;
		$scope.boEditModal=true;
	}
	
	$scope.closeBoEdit = function(){
		$scope.boEditModal = false;
	}
	
})

libraryModule.controller('publisherCtrl', function($scope, $http, $window){
	$http.get('http://localhost:8080/laithproject/viewPublishers').
	success(function(data){
		$scope.publishers = data;
	});

	$scope.addPublisher = function(){
		var publisher = {publisherName: $scope.publisher.publisherName,
						publisherAddress:$scope.publisher.publisherAddress,
						publisherPhone: $scope.publisher.publisherPhone

						};
		$http.post('http://localhost:8080/laithproject/addPublisher', publisher).
		success(function(data){
			$http.get('http://localhost:8080/laithproject/viewPublishers').
			success(function(data){
				$scope.publishers = data;
			});
		});
	}
	
	$scope.preEditPublisher=function(publisherId,publisherName,publisherAddress,publisherPhone){
		
		$scope.publisherId= publisherId;
		$scope.publisherName = publisherName;
		$scope.publisherAddress = publisherAddress;
		$scope.publisherPhone = publisherPhone;
		$scope.pubEditModal=true;
	}

	$scope.editPublisher = function(publisherId,publisherName,publisherAddress,publisherPhone){
		var publisher = {publisherId:publisherId,
				publisherName: publisherName,
				publisherAddress:publisherAddress,
				publisherPhone: publisherPhone
				};
		$http.put('http://localhost:8080/laithproject/editPublisher',publisher).
		success(function(){
			$scope.pubEditModal = false;
			$http.get('http://localhost:8080/laithproject/viewPublishers').
			success(function(data){
				$scope.publishers = data;
			});
			
		})}
	$scope.closePubEdit = function(){
		$scope.pubEditModal = false;
	}
	
	$scope.preDeletePublisher=function(publisherId,publisherName ){
		$scope.publisherId = publisherId;
		$scope.publisherName = publisherName;
		$scope.pubDeleteModal=true;
	}
	$scope.deletePublisher = function(publisherId){
		var publisher = {publisherId: publisherId
			};
		$http.put('http://localhost:8080/laithproject/delPublisher',publisher).
		success(function(){
			$scope.pubDeleteModal = false;
			$http.get('http://localhost:8080/laithproject/viewPublishers').
			success(function(data){
				$scope.publishers = data;
			});
		})}
	
	$scope.closePubDelete= function(){
		$scope.pubDeleteModal = false;
	}
})


libraryModule.controller('genreCtrl', function($scope, $http, $window){
	$http.get('http://localhost:8080/laithproject/viewGenres').
	success(function(data){
		$scope.genres = data;
	});

	$scope.addBorrower = function(){
		var author = {authorName: $scope.author.authorName};
		$http.post('http://localhost:8080/lms/addborrower', borrower).
		success(function(data){
			$window.location.href = "#/genres";
		});
	}
})

libraryModule.controller('branchCtrl', function($scope, $http, $window){
	$http.get('http://localhost:8080/laithproject/viewBranches').
	success(function(data){
		$scope.branches = data;
	});

	$scope.addBorrower = function(){
		var author = {authorName: $scope.author.authorName};
		$http.post('http://localhost:8080/lms/addborrower', borrower).
		success(function(data){
			$window.location.href = "#/branches";
		});
	}
})

libraryModule.controller('bookCtrl', function($scope, $http){
	$http.get('http://localhost:8080/laithproject/viewBooks').
	success(function(data){
		$scope.books = data;
	});

	$scope.addBook = function(){
		var authorList = [];
		for(var i=0;i<book.authurs.length;i++)
		{
			var author={authorId: book.authors[i]};
			authorList.push(author);
		}
		var genreList=[];
		var book = {
				"title": $scope.book.title,
				"authors":authorList,
				"genres": gernreList,
				"publisher":publisher



		}

		{authorName: $scope.book};
		$http.post('http://localhost:8080/laithproject/addAuthor', author).
		success(function(data){
			$window.location.href = "#/authors";
		});
	}

});

