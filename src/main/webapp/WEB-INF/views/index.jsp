<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Project manager welcome</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<p>Welcome to Project Manager app!</p>
	<sec:authorize access="!isAuthenticated()">
		<p>
			Please <a href="<c:url value="/login" />">login</a>
		</p>
	</sec:authorize>
</body>
</html>