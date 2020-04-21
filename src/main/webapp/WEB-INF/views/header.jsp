<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<p style="background-color: black;">

	<a href="<c:url value='/index'/>" style="color: white">Home</a>

	<sec:authorize access="hasRole('USER')">
		<a href="<c:url value='/projects'/>" style="color: white">Projects</a>
	</sec:authorize>

	<sec:authorize access="hasRole('USER')">
		<a href="<c:url value='/tasks'/>" style="color: white">Tasks</a>
	</sec:authorize>

	<sec:authorize access="hasRole('ADMIN')">
		<a href="<c:url value='/admin'/>" style="color: white">Admin</a>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<a href="<c:url value="/logout" />">Logout</a>
	</sec:authorize>

</p>