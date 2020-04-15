<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Task list</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<table border="1" width="100%">
		<tr>
			<th>Project</th>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="task" items="${tasks}" varStatus="status">
			<tr>
				<td>${task.project.name}</td>
				<td>${task.id}</td>
				<td>${task.name}</td>
				<td>${task.description}</td>
				<td><a href="<c:url value='/tasks/edit/${task.id}'/>">Edit</a></td>
				<td><a href="<c:url value='/tasks/del/${task.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="<c:url value='/tasks/add'/>">Add</a>

</body>
</html>