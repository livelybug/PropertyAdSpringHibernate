<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html ng-app="myLoginModule">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="css/libs/bootstrap.min.css">

 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/libs/jquery-2.2.1.js"></script>
<script src="js/libs/angular.js"></script>
<title>Login</title>
<style>
.indent {
    text-indent: 7px;
}
</style>

</head>
<body>

<p/>Customer Login 
<form action="Login.jsp" method="post">
<table>

	<tr style="">
		<td>
		<input type="hidden" name="customerAction" value="submitted">
		</td>
	</tr>

	<tr>
		<td>customer name</td>
		<td>
			<input type="text" name="username" size="30">
		</td>
	</tr>

	<tr>
		<td>password</td>
		<td>
			<input type="password" name="password" size="30">
		</td>
	</tr>
	
	<tr>
		<td colspan="1">
			<input type="submit" name="btSubmit" value="Sign In">
			<input type="reset" name="btCancel" value="Cancel">
		</td>
	</tr>

</table>
</form>


<p/> agent login 
<form action="Login.jsp" method="post">
<table>

	<tr style="">
		<td>
		<input type="hidden" name="agentAction" value="submitted">
		</td>
	</tr>

	<tr>
		<td>agent name</td>
		<td>
			<input type="text" name="username" size="30">
		</td>
	</tr>

	<tr>
		<td>password</td>
		<td>
			<input type="password" name="password" size="30">
		</td>
	</tr>
	
	<tr>
		<td colspan="1">
			<input type="submit" name="btSubmit" value="Sign In">
			<input type="reset" name="btCancel" value="Cancel">
		</td>
	</tr>

</table>
</form>

<p/>
<p class="indent"/><a class="btn btn-success btn-lg btn-block" href="showPropertyList" >
Property List<span id="counter" class="badge"></span></a>

<p/>Not register?

<p class="indent"/> <a class="btn btn-primary btn-lg" href="showCustomerForm" >Customer register</a>
 <a class="btn btn-primary btn-lg" href="showPrptAgentForm" >Property Agent register</a>

<div>
	<%-- <sec:authorize access="hasRole('ROLE_USER')"> --%>
		<a href="showPropertyForm" >Property register</a><p/>
</div>

<a class="btn btn-info" href="${pageContext.request.contextPath}/j_spring_security_logout">
	<span class="glyphicon glyphicon-log-out"></span>logout</a>


<div ng-controller="prpLstCtl"> 
	<ul>
		<li ng-repeat = "prpt in prptList.propertiesList | limitTo:quantity">
			Property Name: {{prpt.propertyName}}		
		</li>
	</ul>
</div>

<script src="js/myJs.js"></script>
  
<script>

	function updateCounter(inData){
		$("#counter").text(inData.total);
	}
	
	function updatePage(){
		//Calling the getProperties() function from controller
		//the map returned by the controller function is converted to a JSON Map here
		$.getJSON("<c:url value="/getProperties"/>", updateCounter);
	}
	
	function onload(){
		updatePage();
		window.setInterval(updatePage, 99000);	//Call function updatePage continuosly  after every 3000 ms (3 seconds)
	}

	$(document).ready(onload);	//JQUERY Statement to call the function onload when the browser page is ready
</script>
 
<!-- <p/> <a href="showCustomerForm" >Customer register</a>
<p/> <a href="showPrptAgentForm" >Property Agent register</a>
 
<p/><a href="showPropertyList" >Property List</a>
 -->

</body>
</html>