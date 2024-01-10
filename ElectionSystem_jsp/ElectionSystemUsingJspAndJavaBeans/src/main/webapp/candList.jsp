<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>

<link href="style.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="cb" class="com.sunbeam.beans.CandidateBean"></jsp:useBean>
	${cb.getCandidates()}
	<form method="post" action="vote.jsp">
		<div class="bulgy-radios" role="radiogroup"
			aria-labelledby="bulgy-radios-label">
			<h2 id="bulgy-radios-label">Hello ${lb.user.firstName}
				${lb.user.lastName}</h2>
			<h2 id="bulgy-radios-label">Choose Your Candidate</h2>

			<c:forEach var="cand" items="${cb.candList }">
				<label> <input type="radio" name="candidateId"
					value="${cand.id }" checked /> <span class="radio"></span> <span
					class="label">${cand.name} of ${cand.party}</span></label>
			</c:forEach>
		</div>
		<br>
		<center><input type = "submit" value = "VOTE"/></center>
	</form>




</body>
</html>