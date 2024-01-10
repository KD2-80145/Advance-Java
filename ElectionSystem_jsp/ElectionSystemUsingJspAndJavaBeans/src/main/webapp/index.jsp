<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>

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
				<form method="post" action="login.jsp">
					<input name="email" type="email" placeholder="Email" required>
					<input name="password" type="password" placeholder="Password"
						required>
					<button class="btn btn-info btn-block login" type="submit">Login</button>
					<a href="register.jsp"><button class="btn btn-info btn-block login" type="button" >Sign-Up</button></a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>