<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="login-container">
			<img class="avatar" alt="Avatar" src="avatar.png">
			<div class="form-box">
				<form method="post" action="adduser.jsp">
					<input name="firstName" type="text" placeholder="First Name" required>
					<input name="lastName" type="text" placeholder="Last Name" required>
					<input name="email" type="email" placeholder="Email" required>
					<input name="password" type="password" placeholder="Password" required>
					<input name="dob" type="date" placeholder="dob" required>
					Role : <b>   </b> <select name = "role">
						<option value = "admin">admin</option>
						<option value = "voter">voter</option> 
					</select>				
					<button class="btn btn-info btn-block login" type="submit">Register</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>