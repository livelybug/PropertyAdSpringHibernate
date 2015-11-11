<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project: property advertisement - property agent register</title>
<link type="text/css" rel="stylesheet" href="css/errorStyle.css">
</head>
<body>
<h1>Property Agent Register</h1>
<h3>Add New Property Agent</h3>

<jsp:include page="PropertyUserForm.jsp">
  <jsp:param name="action" value="addNewPrptAgent"/>
  <jsp:param name="commandName" value="propertyAgent"/>
</jsp:include>

</body>
</html>