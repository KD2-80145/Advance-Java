<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add candidate</title>

<link href="style.css" rel="stylesheet">
</head>
<body>
<jsp:useBean id="acb" class="com.sunbeam.beans.AddCandidatebean"></jsp:useBean>
<jsp:setProperty property="*" name="acb"/>
${acb.save() }
<c:choose>
		<c:when test="${acb.status }">
		<div class="bulgy-radios" role="radiogroup"
		aria-labelledby="bulgy-radios-label">
		<h1 id="bulgy-radios-label" >Candidate Added Succesfully</h1>
		<h1 id="bulgy-radios-label" ><a href ='result.jsp' > Result Page </a></h1>
		</div>
		</c:when>
		<c:when test="${not acb.status }">
		<div class="bulgy-radios" role="radiogroup"
		aria-labelledby="bulgy-radios-label">
		<h1 id="bulgy-radios-label" > Some Error Occured , Try Again with valid Values;</h1>
		<h1 id="bulgy-radios-label" ><a href ='result.jsp' > Result Page </a></h1>
		</div>
		</c:when>
	</c:choose>
</body>
</html>