/**
 * Store custom JS functions
 */

alert("myJs.js");

var myLogin = angular.module("myLoginModule", []);
function prpLstCtl($scope, $http) {
/*	var listRqst = new XMLHttpRequest();
		listRqst.onreadystatechange = function() {
			$scope.$apply(function() {
				if(listRqst.readyState == 4 && listRqst.status == 200) {
					$scope.prptList = JSON.parse(listRqst.responseText);
				}
			});
		}	
	listRqst.open("GET", "getProperties", true);
	listRqst.send();
*/
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
myLogin.controller("prpLstCtl", prpLstCtl);
