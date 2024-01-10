<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication</title>
</head>
<body>
	<jsp:useBean id="lb" class = "com.sunbeam.beans.LoginBean" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name = "lb" />
	${lb.authenticate()}
	<c:choose>
		<c:when test="${empty lb.user }">
			<img alt="INVALID CREDENTIALS Try Again" src="InvalidCredentials.png">
			<a href="index.jsp">Login Again</a>
		</c:when>
		<c:when test="${lb.user.role == 'voter' }">
			<c:redirect url = "candList.jsp"></c:redirect>
		</c:when>
		<c:when test="${lb.user.role == 'admin' }">
			<c:redirect url = "result.jsp" />
		</c:when>
		<c:otherwise>
			<img alt="INVALID CREDENTIALS Try Again" src="InvalidCredentials.png">
			<a href="index.jsp">Login Again</a>
		</c:otherwise>
	</c:choose>
</body>
</html>