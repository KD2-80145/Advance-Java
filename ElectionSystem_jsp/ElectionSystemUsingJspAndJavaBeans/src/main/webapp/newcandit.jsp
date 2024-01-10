<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Candidate</title>

<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="login-container">
			<img class="avatar" alt="Avatar" src="avatar.png">
			<div class="form-box">
				<form method="post" action="addcandidate.jsp">
					<input name="id" type="number" placeholder="Id"  required>
					<input name="name" type="text" placeholder="Name"  required>
					<input name="party" type="text" placeholder="party"  required>
					<input name="votes" type="number" placeholder="Votes" required>
					<button class="btn btn-info btn-block login" type="submit">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>