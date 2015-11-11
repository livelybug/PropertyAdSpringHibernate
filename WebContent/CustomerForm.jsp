<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project: property advertisement - customer register</title>
<link type="text/css" rel="stylesheet" href="css/errorStyle.css">
</head>
<body>
<h1>Customer Register</h1>
<h3>Add New Customer</h3>

<jsp:include page="PropertyUserForm.jsp">
  <jsp:param name="action" value="addNewCustomer"/>
  <jsp:param name="commandName" value="customer"/>
</jsp:include>

<%-- <%@ include file="PropertyUserForm.jsp" %> --%>

</body>
</html>