module = angular.module('digitalOrderSystemApp', []);
module.controller('DigitalOrderSystemController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    $http.defaults.headers.common[header] = token;
	    console.log(token);
	    
	    $scope.addArticle = function(article, form){
        	
        	  	$http({
	                method: "POST",
	                url: "/api/v1/article/create",
	                data: article,
	            }).then(function mySucces(response) {
	            		$scope.createStatus="Article created";
	            }, function myError(response) {
	            		$scope.createStatus="Error in article creation";
	            });

        };
        
        $scope.appInit = function(){
        
	        	$http({
	                method: "GET",
	                url: "/rest/dos/category/all",
	                params: {}
	            }).then(function succes(response) {
	               
	            		$scope.categories = response.data;
	                
	            }, function error(response) {
	            });
        };
        
        $scope.findFoodsByCategory=function(categoryId){
        		$http({
                method: "GET",
                url: "/rest/dos/food/category/"+categoryId,
                params: {}
            }).then(function succes(response) {
               
            		$scope.foods = response.data;
                
            }, function error(response) {
            });
        }
        
        $scope.findAllFoods = function(){
        	$http({
                method: "GET",
                url: "/rest/dos/food/all",
                params: {}
            }).then(function succes(response) {
               
            		$scope.foods = response.data;
                
            }, function error(response) {
            });
        }

    }])
    