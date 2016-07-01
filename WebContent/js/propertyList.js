/**
 * Store custom JS functions
 */

alert("propertyList.js");

var propertyList = angular.module("propertyListModule", []);
function prpLstCtl($scope, $http) {

	$scope.quantity = 3;
	$http.get("getProperties")
		.success(function(result) {
			$scope.prptList = result;
		})
		.error(function(data, status) {
			console.log(data);
		})
}

prpLstCtl.$inject = ["$scope", "$http"];
propertyList.controller("prpLstCtl", prpLstCtl);
