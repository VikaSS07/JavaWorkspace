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
	
		<div class="container my-5">
		<h1 class="text-center mb-5">My Friends</h1>
		<div class="row">
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<img class="card-img-top" src="https://via.placeholder.com/300x200"
						alt="">
					<div class="card-body">
						<h4 class="card-title">Friend 1</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Suspendisse non nulla vitae neque scelerisque
							commodo.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">View Profile</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<img class="card-img-top" src="https://via.placeholder.com/300x200"
						alt="">
					<div class="card-body">
						<h4 class="card-title">Friend 2</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Suspendisse non nulla vitae neque scelerisque
							commodo.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">View Profile</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<img class="card-img-top" src="https://via.placeholder.com/300x200"
						alt="">
					<div class="card-body">
						<h4 class="card-title">Friend 3</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Suspendisse non nulla vitae neque scelerisque
							commodo.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">View Profile</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<img class="card-img-top" src="https://via.placeholder.com/300x200"
						alt="">
					<div class="card-body">
						<h4 class="card-title">Friend 4</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Suspendisse non nulla vitae neque scelerisque
							commodo.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">View Profile</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<img class="card-img-top" src="https://via.placeholder.com/300x200"
						alt="">
					<div class="card-body">
						<h4 class="card-title">Friend 5</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Suspendisse non nulla vitae neque scelerisque
							commodo.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">View Profile</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<img class="card-img-top" src="https://via.placeholder.com/300x200"
						alt="">
					<div class="card-body">
						<h4 class="card-title">Friend 6</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Suspendisse non nulla vitae neque scelerisque
							commodo.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">View Profile</a>
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