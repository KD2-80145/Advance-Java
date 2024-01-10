<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>

<link href="style.css" rel="stylesheet">
</head>
<body>
<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"> </jsp:useBean>
<jsp:setProperty name="vb" property="user" value = "${lb.user }"/>
<jsp:setProperty name="vb" property="*" />
${vb.vote()}
	<div class="bulgy-radios" role="radiogroup"
		aria-labelledby="bulgy-radios-label">
		<h2 id="bulgy-radios-label">Hello ${lb.user.firstName}
			${lb.user.lastName}</h2>
		<h2 id="bulgy-radios-label"> ${vb.message}</h2>
		<a href="logout.jsp"><h2 id="bulgy-radios-label">Logout</h2></a>
	</div>
</body>
</html>