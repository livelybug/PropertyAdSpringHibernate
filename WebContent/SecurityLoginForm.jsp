<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Security Login Page</title>
<link href="css/errorStyle.css" rel="stylesheet" type="text/css" />
<link href="css/libs/bootstrap.css" rel="stylesheet">
</head>
<body onload='document.f.j_username.focus();'>
	<div class="container col-md-6 col-md-offset-3">
		<form action="${pageContext.request.contextPath }/j_spring_security_check" method="post" name="f" class="form-signin">       
		    <h3 class="form-signin-heading" align="center">Login with Username and Password</h3>
			 <c:if test="${param.error != null }">
			 	<p class="fieldErrors">Invalid Username or Password<br/>Please try again.</p>
			 </c:if>
			 		  
			  <input type="text" class="form-control" name="j_username" placeholder="Username" /><br/>
			  <input type="password" class="form-control" name="j_password" placeholder="Password"/>     		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">
			  	<span class="glyphicon glyphicon-log-in"></span> Login
			  </button>  			
		</form>
</div>
</body>
</html>