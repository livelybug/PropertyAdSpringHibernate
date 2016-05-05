<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html>
<html>
<head>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project: property advertisement - property list</title>
<link type="text/css" rel="stylesheet" href="css/libs/bootstrap.min.css"> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SpringWebMVC-02: spring web beans</title>
<link type="text/css" rel="stylesheet" href="css/libs/bootstrap.min.css">
</head>
<body>
<h1>Property  List</h1>


<c:if test="${! empty propertyList}">
<table  class="table table-striped">
<!-- <table> -->
	<tr>
		<th><spring:message code="label.propertyName"/></th>
		<th><spring:message code="label.address.address"/></th>
		<%-- <th><spring:message code="label.address.postcode"/></th> --%>
		<th><spring:message code="label.rent_sale"/></th>
		<th><spring:message code="label.mobile"/></th>
		<th><spring:message code="label.comment"/></th>
		<th><spring:message code="label.action"/></th>
		<th><spring:message code="label.mailAgent"/></th>
	</tr>
	
	<c:forEach items="${propertyList}" var="property">
		<tr>
			<td>${property.getPropertyName()}</td>
			<td>${property.getAddress().getAddress()} ${property.getAddress().getPostcode()}</td>
			<td>${property.getRent_sale()}</td>
			<td>${property.getpAgt().getMobile()}</td>
			<td>${property.getComment()}</td>
			<td>
			<%-- <a class="btn btn-warning" href="editProperty/${property.getPropertyId() }"> --%>
			<a class="btn btn-warning" href="editProperty">
			<span class="glyphicon glyphicon-edit"></span>Edit</a> 
			
			<%-- <a class="btn btn-danger" href="delete/${property.getPropertyId() }"> --%>
			<a class="btn btn-danger" href="delete">
			<span class="glyphicon glyphicon-remove"></span>Delete</a>
			</td>
			<td>${property.getComment()}</td>
		</tr>
	</c:forEach>	

</table>
</c:if>

<a href="PrptListExcel">Excel</a>
<a href="PrptListPdf">PDF</a>
<a href="${pageContext.request.contextPath}/">back home</a>

</body>
</html>