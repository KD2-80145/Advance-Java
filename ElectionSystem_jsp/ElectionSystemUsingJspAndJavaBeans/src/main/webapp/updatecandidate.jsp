<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="ub" class="com.sunbeam.beans.UpdateCandidate"></jsp:useBean>
	<jsp:setProperty name="ub" property="*" />
	${ub.update()}
	<jsp:forward page="result.jsp">
		<jsp:param value="${ub.message }" name="message"/>
	</jsp:forward>
</body>
</html>