<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>

<link href="style.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="ab" class="com.sunbeam.beans.RegistrationBean"></jsp:useBean>
	<jsp:setProperty property="*" name="ab"/>
	${ab.save()}
	<c:choose>
		<c:when test="${ab.status }">
		<div class="bulgy-radios" role="radiogroup"
		aria-labelledby="bulgy-radios-label">
		<h1 id="bulgy-radios-label" > User Registered Succesfully</h1>
		<a href ='index.jsp' > Login </a>
		</div>
		</c:when>
		<c:when test="${not ab.status }">
		<div class="bulgy-radios" role="radiogroup"
		aria-labelledby="bulgy-radios-label">
		<h1 id="bulgy-radios-label" > Some Error Occured , Try Again with valid Values;</h1>
		<h1 id="bulgy-radios-label" ><a href ='register.jsp' > Sign-up-Again </a></h1>
		</div>
		</c:when>
	</c:choose>
	
</body>
</html>