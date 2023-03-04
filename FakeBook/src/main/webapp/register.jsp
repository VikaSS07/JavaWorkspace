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
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
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
	<div class="container-fluid" style="margin-top: 50px">
		<div class="row justify-content-center">
			<div class="col-lg-6 col-md-8 col-sm-10 col-12">
				<form class="bg-light p-4" action="register" method="post">
					<h2 class="mb-3 text-center">Create an account</h2>
					<%
					String message = "";
					String color = "";
					if (request.getParameter("code") != null) {
						switch (request.getParameter("code")) {
						case "200":
							message = "Account created Successfully, Please Login";
							color = "success";
							break;
						case "500":
							message = "password doesnot match, Try Again";
							color = "danger";
							break;
						}
					%>
					<div class="alert alert-<%=color%>" role="alert"><%=message%></div>
					<%
					}
					%>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="firstName">First name:</label> <input type="text"
								class="form-control" name="firstName"
								placeholder="Enter first name" required>
						</div>
						<div class="form-group col-md-6">
							<label for="lastName">Last name:</label> <input type="text"
								class="form-control" name="lastName"
								placeholder="Enter last name" required>
						</div>
					</div>
					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" name="email" placeholder="Enter email"
							required>
					</div>
					<div class="form-group">
						<label for="phoneNumber">Phone number:</label> <input type="tel"
							class="form-control" name="phoneNumber"
							placeholder="Enter phone number" required>
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" name="password" placeholder="Enter password"
							required>
					</div>
					<div class="form-group">
						<label for="confirmPassword">Confirm password:</label> <input
							type="password" class="form-control" name="confirmPassword"
							placeholder="Confirm password" required>
					</div>
					<div class="form-group">
						<label for="dob">Date of birth:</label> <input type="date"
							class="form-control" name="dob" required>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" name="terms"
							required> <label class="form-check-label" for="terms">I
							agree to the terms and conditions</label>
					</div>
					<button type="submit" class="btn btn-primary btn-block">Register</button>
					<p class="text-center mt-3">
						Already have an account? <a href="#">Log in</a>
					</p>
				</form>
			</div>
		</div>
	</div>


	<%@ include file="bootstrapJsCss.jsp"%>
</body>
</html>
<%
}
%>