/**
 * Store custom JS functions
 */

alert("propertyList.js");

var propertyList = angular.module("propertyListModule", ['angularUtils.directives.dirPagination']);
function prpLstCtl($scope, $http) {

	$scope.quantity = 2;
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
