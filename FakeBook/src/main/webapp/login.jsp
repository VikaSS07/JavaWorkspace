<%@page import="edu.fakebook.utilities.Validate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="bootstrapJsCss.jsp"%>
</head>

<body>
	<%
	if (Validate.validateUser(request)) {
		response.sendRedirect("index.jsp");
	} else {
	%>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="login.jsp"> <img
				src="https://www.w3schools.com/bootstrap5/img_avatar1.png"
				alt="Avatar Logo" style="width: 40px;" class="rounded-pill">
			</a> <a class="navbar-brand" href="login.jsp">FakeBook</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#mynavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="mynavbar"></div>
		</div>
	</nav>
	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<%
				String message = "";
				String color = "";
				if (request.getParameter("code") != null) {
					switch(request.getParameter("code")){
					case "200":
						message ="Account created Successfully, Please Login";
						color = "success";
						break;
					case "500":
						message ="Incorrect UserName or Password, Try Again";
						color = "danger";
						break;
					case "501":
						message ="Failed to create account, Try Again";
						color = "danger";
					}
				%>
				<div class="alert alert-<%=color %>" role="alert"><%= message %></div>
				<%
				}
				%>
				<div class="card">
					<div class="card-header">Login To FakeBook</div>
					<div class="card-body">
						<form action="login" method="post">
							<div class="form-group">
								<label for="username">Username/PhoneNo:</label> <input
									type="text" class="form-control" id="username" name="username"
									required>
							</div>
							<div class="form-group">
								<label for="password">Password:</label> <input type="password"
									class="form-control" id="password" name="password" required>
							</div>
							<button type="submit" class="btn btn-primary">Login</button>
						</form>
					</div>
					<div class="card-footer">
						Don't have an account? <a href="register.jsp">Sign up</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="bootstrapJsCss.jsp"%>
</body>
</html>
<%
}
%>