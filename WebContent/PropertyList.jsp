<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project: property advertisement - property list</title>
</head>
<body>
<h1>Property  List</h1>


<c:if test="${! empty propertyList}">
<table border="1">

	<tr>
		<th><spring:message code="label.propertyName"/></th>
		<th><spring:message code="label.address.address"/></th>
		<%-- <th><spring:message code="label.address.postcode"/></th> --%>
		<th><spring:message code="label.rent_sale"/></th>
		<th><spring:message code="label.mobile"/></th>
		<th><spring:message code="label.comment"/></th>
		<th><spring:message code="label.action"/></th>
	</tr>
	
	<c:forEach items="${propertyList}" var="property">
		<tr>
			<td>${property.getPropertyName()}</td>
			<td>${property.getAddress().getAddress()} ${property.getAddress().getPostcode()}</td>
			<td>${property.getRent_sale()}</td>
			<td>${property.getpAgt().getMobile()}</td>
			<td>${property.getComment()}</td>
			<td>
			<a href="editProperty/${property.getPropertyId() }">Edit</a> 
			<a href="delete/${property.getPropertyId() }">Delete</a>
			</td>
		</tr>
	</c:forEach>	

</table>
</c:if>

<a href="${pageContext.request.contextPath}/">back home</a>

</body>
</html>