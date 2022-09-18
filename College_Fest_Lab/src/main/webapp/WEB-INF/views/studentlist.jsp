<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Customers</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
th, td {
	padding: 3px;
}

table, th, td {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
}
</style>
</head>
<body>
	<div class="container">
		<h1>List of Students</h1>
		<div>
			<form action="/College_Fest_Lab/students/showform" method="Get">
				<a href="/College_Fest_Lab/students/showform"><button>Add
						Student</button></a>
			</form>
			<br>
		</div>
		<table class="table">
			<tr>
				<th>Student Id</th>
				<th>Name</th>
				<th>Department</th>
				<th>Country</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${students }" var="student">
				<tr>
					<td>${student.id }</td>
					<td>${student.name }</td>
					<td>${student.department }</td>
					<td>${student.country }</td>
					<td><a href="/College_Fest_Lab/students/update/${student.id }"><button>Update</button></a>
						<a href="/College_Fest_Lab/students/delete/${student.id }"><button>Delete</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>