<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.PrintWriter" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserAction</title>
</head>
<body>

<p/>Not register?

<p/>Customer register <a href="showCustomerForm" >Click here</a>

<p/>Property Agent register <a href="Register.jsp" >Click here</a>

<p/>Customer Login 
<form action="Login.jsp" method="post">
<table>

	<tr style="">
		<td>
		<input type="hidden" name="customerAction" value="submitted">
		</td>
	</tr>

	<tr>
		<td>customer name</td>
		<td>
			<input type="text" name="username" size="30">
		</td>
	</tr>

	<tr>
		<td>password</td>
		<td>
			<input type="password" name="password" size="30">
		</td>
	</tr>
	
	<tr>
		<td colspan="1">
			<input type="submit" name="btSubmit" value="Sign In">
			<input type="reset" name="btCancel" value="Cancel">
		</td>
	</tr>

</table>
</form>


<p/> agent login 
<form action="Login.jsp" method="post">
<table>

	<tr style="">
		<td>
		<input type="hidden" name="agentAction" value="submitted">
		</td>
	</tr>

	<tr>
		<td>agent name</td>
		<td>
			<input type="text" name="username" size="30">
		</td>
	</tr>

	<tr>
		<td>password</td>
		<td>
			<input type="password" name="password" size="30">
		</td>
	</tr>
	
	<tr>
		<td colspan="1">
			<input type="submit" name="btSubmit" value="Sign In">
			<input type="reset" name="btCancel" value="Cancel">
		</td>
	</tr>

</table>
</form>

</body>
</html>