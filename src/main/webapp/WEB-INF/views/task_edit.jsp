<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Task edit</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/tasks"
		modelAttribute="task">
		<form:hidden path="id" />

		<form:select path="projectId">
			<c:forEach items="${projectList}" var="s" varStatus="status">
				<c:choose>
					<c:when test="${s.id eq task.projectId}">
						<option value="${s.id}" selected="true">${s.name}</option>
					</c:when>
					<c:otherwise>
						<option value="${s.id}">${s.name}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</form:select>

		<p>Name:</p>
		<p>
			<form:input path="name" />
		</p>
		<p>Description:</p>
		<p>
			<form:input path="description" />
		</p>
		<p>Begin:</p>
		<p>
			<form:input type="date" path="dateBegin" />
		</p>
		<p>End:</p>
		<p>
			<form:input type="date" path="dateEnd" />
		</p>
		<p>
			<form:button>OK</form:button>
		</p>
	</form:form>
</body>
</html>