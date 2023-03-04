<%@page import="edu.fakebook.utilities.Validate"%>
<%@page import="edu.fakebook.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="bootstrapJsCss.jsp"%>
<meta charset="ISO-8859-1">
<title>New Post | Social Media</title>
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
	<%
	String message = "";
	String color = "";
	if (request.getParameter("code") != null) {
		switch (request.getParameter("code")) {
		case "200":
			message = "Posted Successfully";
			color = "success";
			break;
		case "500":
			message = "Failed to Post, Try Again";
			color = "danger";
		}
	%>
	<div style="text-align: center; margin-top: 60px" class="alert alert-<%=color%>" role="alert"><%=message%></div>
	<%
	}
	%>
	<div class="card">
		<div class="card-header">Upload a New Post</div>
		<div class="card-body">
			<form action="newpost" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="post-title">Title:</label> <input required type="text"
						class="form-control" name="title">
				</div>
				<div class="form-group">
					<label for="post-image">Image:</label>
					<div class="custom-file">
						<input type="file" required class="custom-file-input" name="filecover"
							id="image"> <label class="custom-file-label" for="image">Choose
							file</label>
					</div>
				</div>
				<div class="form-group">
					<label for="post-content">Content:</label>
					<textarea class="form-control" required name="content" rows="5"></textarea>
				</div>
				<button type="submit" class="btn btn-primary btn-block">Submit</button>
			</form>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<%@ include file="bootstrapJsCss.jsp"%>
	<%
	}
	%>
</body>
</html>