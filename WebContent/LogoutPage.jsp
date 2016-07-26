<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout Success</title>
<!-- Bootstrap -->
<link href="css/libs/bootstrap.css" rel="stylesheet">
</head>
<body>
	<h3 align="center">
		You Have Been Logged Out. 
		<br/><br/>
		To login again click here
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/"> 
			Login
		</a>
	</h3>
</body>
</html>