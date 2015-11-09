<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project: property advertisement - Customer Register</title>
<link type="text/css" rel="stylesheet" href="css/errorStyle.css">
</head>
<body>
<h1>Customer Register</h1>
<h3>Add New Customer</h3>

<form:form action="addNewCustomer" method="post" commandName="customer">
<table>
	<tr>
		<td><spring:message code="label.username"/></td>
		<td><form:input path="username" size="30"/></td>
		<%-- <td><form:errors path="firstName" cssClass="fieldErrors"></form:errors></td> --%>	
	</tr>
	<tr>
		<td><spring:message code="label.password"/></td>
		<td><form:input type="password" path="password" size="30"/></td>
		<%-- <td><form:errors path="lastName" cssClass="fieldErrors"></form:errors></td>	 --%>
	</tr>
	<tr>
		<td><spring:message code="label.firstName"/></td>
		<td><form:input path="firstName" size="30"/></td>
		<%-- <td><form:errors path="firstName" cssClass="fieldErrors"></form:errors></td> --%>	
	</tr>
	<tr>
		<td><spring:message code="label.lastName"/></td>
		<td><form:input path="lastName" size="30"/></td>
		<%-- <td><form:errors path="lastName" cssClass="fieldErrors"></form:errors></td>	 --%>
	</tr>
	<tr>
		<td><spring:message code="label.gender"/></td>
		<td>
		<form:radiobutton path="gender" value="male"/><spring:message code="label.male"/>
		<form:radiobutton path="gender" value="female"/><spring:message code="label.female"/>	
		</td>
		<%-- <td><form:errors path="gender" cssClass="fieldErrors"></form:errors></td> --%>
	</tr>

	<tr>
		<td><spring:message code="label.email"/></td>
		<td><form:input type="email" path="email" size="30"/></td>
		<%-- <td><form:errors path="email" cssClass="fieldErrors"></form:errors></td> --%>	
	</tr>

	<tr>
		<td><spring:message code="label.mobile"/></td>
		<td><form:input type="tel" path="mobile" size="30"/></td>
		<%-- <td><form:errors path="mobile" cssClass="fieldErrors"></form:errors></td> --%>	
	</tr>

	<tr>
		<td><spring:message code="label.address.address"/></td>
		<td><form:input path="address.address" size="30"/></td>
		<%-- <td><form:errors path="mobile" cssClass="fieldErrors"></form:errors></td> --%>	
	</tr>

	<tr>
		<td><spring:message code="label.address.postcode"/></td>
		<td><form:input placeholder="Pleas input six digits" path="address.postcode" size="30"/></td>
		<%-- <td><form:errors path="mobile" cssClass="fieldErrors"></form:errors></td> --%>	
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