<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Election Result</title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link href="table.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="rb" class="com.sunbeam.beans.ResultBeans" />
	${rb.getResult()}
	<div class="bulgy-radios" role="radiogroup"
		aria-labelledby="bulgy-radios-label">
		<div class="container-lg">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-8">
						<h2 id="bulgy-radios-label">Hello ${lb.user.firstName}
							${lb.user.lastName}</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<h2 id="bulgy-radios-label">Election Results</h2>
					</div>
					<div class="col-sm-4">
					<a href ="newcandit.jsp">
						<button type="button" class="btn btn-info add-new">
							 <i class="fa fa-plus" ></i> Add New 
						</button>
						</a>
					</div>
				</div>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Party</th>
						<th>Votes</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${rb.candLise}">
						<tr>
							<td>${c.id}</td>
							<td>${c.name}</td>
							<td>${c.party}</td>
							<td>${c.votes}</td>
							<td><a href="editcand.jsp?id=${c.id}"><img alt="edit"
									src="edit.png" height='24' width='24'></a> <a
								href="delcand.jsp?id=${c.id}"><img alt="delete"
									src="delete.png" height='24' width='24'></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row">
				<div class="col-sm-8">
					<h4 id="bulgy-radios-label">${param.message}</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8">
					<h4 id="bulgy-radios-label">${db.message}</h4>
				</div>
				<div class="col-sm-4">
					<a href="logout.jsp"><h3 id="bulgy-radios-label">Logout</h3></a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>