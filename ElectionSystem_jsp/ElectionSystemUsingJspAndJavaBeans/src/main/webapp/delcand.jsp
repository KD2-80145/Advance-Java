<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>
	<jsp:useBean id="db" class="com.sunbeam.beans.DeleteCandBean" scope="request"></jsp:useBean>
	<jsp:setProperty name = "db" property="*" />
	${db.delete()}
	<jsp:forward page="result.jsp"></jsp:forward>
	
</body>
</html>