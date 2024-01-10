<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="style.css" rel="stylesheet">
</head>
<body>
<jsp:useBean id="fb" class="com.sunbeam.beans.FindCandBean"></jsp:useBean>
<jsp:setProperty property="*" name="fb"/>
${fb.find()}
	<div class="container">
		<div class="login-container">
			<img class="avatar" alt="Avatar" src="avatar.png">
			<div class="form-box">
				<form method="post" action="updatecandidate.jsp">
					<input name="id" type="hidden"  value = "${fb.id }" required>
					<input name="name" type="text" placeholder="Name" value = "${fb.name }" required>
					<input name="party" type="text" placeholder="party" value ="${fb.party }" required>
					<input name="votes" type="number" placeholder="Votes" value = "${fb.votes }" readonly required>
					<button class="btn btn-info btn-block login" type="submit">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>