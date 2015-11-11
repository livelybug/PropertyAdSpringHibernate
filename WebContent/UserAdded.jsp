<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Registration Done!</h1>

<c:choose>

    <c:when test="${customer != null && customer.getFirstName() != null && customer.getLastName() != null}">
		Welcome Property Customer ${customer.getFirstName()} ${customer.getLastName()}
        <br />
    </c:when>    

    <c:when test="${propertyAgent != null && propertyAgent.getFirstName() != null && propertyAgent.getLastName() != null}">
		Welcome Property Agent ${propertyAgent.getFirstName()} ${propertyAgent.getLastName()}
        <br />
        Property register <a href="showPropertyForm" >Click here</a><p/>
    </c:when>

	<c:otherwise>
		<!-- something wrong ?? -->
    </c:otherwise>
</c:choose>

	<br /><a href="showPropertyList" >Property List</a><p/>
<p/>
<%-- <a href="${pageContext.request.contextPath}/">back home</a> --%>
<a href="Login.jsp">back home</a>

</body>
</html>