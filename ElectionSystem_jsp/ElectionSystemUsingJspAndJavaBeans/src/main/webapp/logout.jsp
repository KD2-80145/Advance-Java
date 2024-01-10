<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>

<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class="bulgy-radios" role="radiogroup"
		aria-labelledby="bulgy-radios-label">
		<h2 id="bulgy-radios-label">Bye ${lb.user.firstName}
			${lb.user.lastName}</h2>
			<% session.invalidate(); %>
		<h2 id="bulgy-radios-label"> Thank you for voting</h2>
		<a href="index.jsp"><h2 id="bulgy-radios-label">Login-Again</h2></a>
	</div>
</body>
</html>