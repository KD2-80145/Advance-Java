<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login_Page</title>
</head>
<body>
	<center>
		<br>
		<form method="post" action="register.jsp">
			<h1 style=""textAlign: 'center' }}>Register</h1>
			First Name : <input type="text" name="firstName"
				placeholder='First Name'><br> <br> Last Name : <input
				type="text" name="lastName" placeholder='Last Name'><br>
			<br> Email : <input type="email" name="email" required
				placeholder='Email here'><br> <br> Password : <input
				type="password" name="password" required placeholder='Password'><br>
			<br> Mobile : <input type="text" name="mobile"
				placeholder='Mobile'><br> <br> Birth : <input
				type="date" name="birth" required><br> <br> <input
				type="submit" value="Register_me">
		</form>
	</center>
</body>
</html>