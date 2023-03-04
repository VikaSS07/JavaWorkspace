<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="edu.fakebook.utilities.Validate"%>
<%@page import="edu.fakebook.entities.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="bootstrapJsCss.jsp"%>
</head>
<body>
	<%
	User user = null;
	if (!Validate.validateUser(request)) {
		response.sendRedirect("login.jsp");
	} else {
		user = (User) request.getSession().getAttribute("user");
	%>
	<%@ include file="NavBar.jsp"%>
	<%@ include file="bootstrapJsCss.jsp"%>
</body>
</html>
<%
}
%>