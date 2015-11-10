<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form:form action="${param.action}" method="post" commandName="${param.commandName}">
<table>
	<tr>
		<td><spring:message code="label.username"/></td>
		<td><form:input path="username" size="30"/></td>
		<td><form:errors path="username" cssClass="fieldErrors"></form:errors></td>	
	</tr>
	<tr>
		<td><spring:message code="label.password"/></td>
		<td><form:input type="password" path="password" size="30"/></td>
		<td><form:errors path="password" cssClass="fieldErrors"></form:errors></td>	
	</tr>
	
	<c:if test="${param.commandName == 'propertyAgent'}">
		<tr>
			<td><spring:message code="label.licence"/></td>
			<td><form:input path="licence" size="30"/></td>
			<td><form:errors path="licence" cssClass="fieldErrors"></form:errors></td>	
		</tr>	
	</c:if>
	
	<tr>
		<td><spring:message code="label.firstName"/></td>
		<td><form:input path="firstName" size="30"/></td>
		<td><form:errors path="firstName" cssClass="fieldErrors"></form:errors></td>	
	</tr>
	<tr>
		<td><spring:message code="label.lastName"/></td>
		<td><form:input path="lastName" size="30"/></td>
		<td><form:errors path="lastName" cssClass="fieldErrors"></form:errors></td>	
	</tr>
	<tr>
		<td><spring:message code="label.gender"/></td>
		<td>
		<form:radiobutton path="gender" value="male"/><spring:message code="label.male"/>
		<form:radiobutton path="gender" value="female"/><spring:message code="label.female"/>	
		</td>
		<td><form:errors path="gender" cssClass="fieldErrors"></form:errors></td>
	</tr>

	<tr>
		<td><spring:message code="label.email"/></td>
		<td><form:input type="email" path="email" size="30"/></td>
		<td><form:errors path="email" cssClass="fieldErrors"></form:errors></td>	
	</tr>

	<tr>
		<td><spring:message code="label.mobile"/></td>
		<td><form:input type="tel" path="mobile" size="30"/></td>
		<td><form:errors path="mobile" cssClass="fieldErrors"></form:errors></td>	
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
		<td colspan="1">
			<input type="submit" name="btSubmit" value="<spring:message code='label.button.add'/>">
			<input type="reset" name="btCancel" value="<spring:message code='label.button.cancel'/>">
		</td>
	</tr>

</table>
</form:form>