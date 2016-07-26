<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html ng-app="propertyListModule">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Property List</title>
<link type="text/css" rel="stylesheet" href="css/libs/bootstrap.min.css">
<script src="js/libs/angular.js"></script>
<script src="js/libs/dirPagination.js"></script>
<link type="text/css" rel="stylesheet" href="css/app.css">
</head>
<body>
<h1>Property  List</h1>

<div ng-controller="prpLstCtl">
	<div ng-if="prptList.propertiesList">
	
	<form>
		<div class="form-group">
			<label>Search</label>
			<input type="text" ng-model="search" placeholder="Search">
		</div>
	</form>
	
		<table  class="table table-striped">
			<tr>
				<th><spring:message code="label.propertyName"/></th>
				<th><spring:message code="label.address.address"/></th>
				<th><spring:message code="label.address.postcode"/></th>
				<th><spring:message code="label.rent_sale"/></th>
				<th><spring:message code="label.mobile"/></th>
				<th><spring:message code="label.comment"/></th>
				<th><spring:message code="label.action"/></th>
				<th><spring:message code="label.mailAgent"/></th>
			</tr>
			
		    <tr dir-paginate = "property in prptList.propertiesList | itemsPerPage:quantity | filter:search" ng-cloak>
			
				<td>{{property.propertyName}}</td>
				<td>{{property.address.address}}</td>
				<td>{{property.address.postcode}}</td>
				<td>{{property.rent_sale}}</td>
				<td>{{property.pAgt.mobile}}</td>
				<td>{{property.comment}}</td>
				<td>
					<a class="btn btn-warning" href="editProperty">
					<span class="glyphicon glyphicon-edit"></span>Edit</a> 
					
					<a class="btn btn-danger" href="delete">
					<span class="glyphicon glyphicon-remove"></span>Delete</a>
				</td>
				<td>{{property.pAgt.username}}</td>
			</tr>
		
		</table>	
		
		<dir-pagination-controls
	       max-size="5"
	       direction-links="true"
	       boundary-links="true" >
	    </dir-pagination-controls>
	</div>
</div>

<!-- <a href="PrptListExcel">Excel</a> -->
<sec:authorize access="hasRole('ROLE_USER')">
	<a href="PrptListExcel">Excel</a>
</sec:authorize>

<a href="PrptListPdf">PDF</a>
<a href="${pageContext.request.contextPath}/">back home</a>

<a class="btn btn-info" href="${pageContext.request.contextPath}/j_spring_security_logout">
	<span class="glyphicon glyphicon-log-out"></span>logout</a>

<script src="js/propertyList.js"></script>

</body>
</html>