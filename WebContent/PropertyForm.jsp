<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project: property advertisement - property register</title>
<link type="text/css" rel="stylesheet" href="css/errorStyle.css">
</head>
<body>
<h1>Property  Register</h1>
<h3>Add New Property</h3>


<form:form action="addNewProperty" method="post" commandName="property">
<table>
	<tr>
		<td><spring:message code="label.propertyName"/></td>
		<td><form:input path="propertyName" size="30"/></td>
		<td><form:errors path="propertyName" cssClass="fieldErrors"></form:errors></td>	
	</tr>

	<tr>
		<td><spring:message code="label.address.address"/></td>
		<td><form:input path="address.address" size="30"/></td>
		<td><form:errors path="address.address" cssClass="fieldErrors"></form:errors></td>	
	</tr>

	<tr>
		<td><spring:message code="label.address.postcode"/></td>
		<td><form:input placeholder="Pleas input six digits" path="address.postcode" size="30"/></td>
		<td><form:errors path="address.postcode" cssClass="fieldErrors"></form:errors></td>	
	</tr>

	<tr>
		<td><spring:message code="label.rent_sale"/></td>
		<td>
		<form:radiobutton path="rent_sale" value="Rent"/><spring:message code="label.rent"/>
		<form:radiobutton path="rent_sale" value="Sale"/><spring:message code="label.sale"/>	
		</td>
		<td><form:errors path="rent_sale" cssClass="fieldErrors"></form:errors></td>
	</tr>

	<tr>
		<td><spring:message code="label.comment"/></td>
		<td><form:input  path="comment" size="30"/></td>
		<td><form:errors path="comment" cssClass="fieldErrors"></form:errors></td>	
	</tr>

	<tr>
		<td>Property Photo</td>
		<td>
			<input type="file" name="image" size="30">
		</td>
	</tr>

	<tr>
		<td colspan="1">
			<input type="submit" name="btSubmit" value="<spring:message code='label.button.add'/>">
			<input type="reset" name="btCancel" value="<spring:message code='label.button.cancel'/>">
		</td>
	</tr>

</table>
</form:form>
</body>
</html>