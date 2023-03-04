<%@page import="edu.fakebook.entities.Post"%>
<%@page import="edu.fakebook.entities.User"%>
<%@page import="edu.fakebook.utilities.Validate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User user = null;
if (!Validate.validateUser(request)) {
	response.sendRedirect("login.jsp");
} else {
	user = (User) request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="bootstrapJsCss.jsp"%>
<meta charset="ISO-8859-1">
<title>profile</title>
</head>
<body>
	<%@ include file="NavBar.jsp"%>

	<div class="container my-5">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<%
					if (!user.getImagePath().equals("N/A")) {
					%>
					<img src="<%=user.getImagePath()%>" class="card-img-top" alt="...">
					<%
					} else {
					%>
					<form action="updateprofilepic" method="post"
						enctype="multipart/form-data">
						<div>
							<div class="d-flex justify-content-center mb-4">
								<img
									src="https://mdbootstrap.com/img/Photos/Others/placeholder-avatar.jpg"
									class="rounded-circle" alt="example placeholder"
									style="width: 200px;" />
							</div>
							<div class="d-flex justify-content-center">
								<div class="btn btn-primary btn-rounded">

									<label class="form-label text-white m-1" for="customFile2">Choose
										Profile Picture</label> <input required="required" type="file"
										class="form-control d-none" id="customFile2" name="filecover"
										value="Upload" />
									<button type="submit" class="btn btn-tertiary"
										style="color: white">Update</button>

								</div>
							</div>
						</div>
					</form>
					<%
					}
					%>
					<div class="card-body">
						<h5 class="card-title"><%=user.getName()%></h5>
						<p class="card-text"><%=user.getBio()%></p>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">About Me</div>
					<div class="card-body">
						<p class="card-text">
							Bio:
							<%=user.getBio()%></p>
						<p class="card-text">
							Date Of Birth:
							<%=user.getDateOfBirth()%></p>

						<p class="card-text">
							Status:
							<%=user.getStatus()%></p>
						<p class="card-text">
							Studied At:
							<%=user.getStudiedAt()%></p>


					</div>
				</div>
				<div class="card mt-3">
					<div class="card-header">My Posts</div>
					<ul class="list-group list-group-flush">
						<%
						for (Post post : user.getPosts()) {
						%>
						<li class="list-group-item"><span style="font-weight: bold;"><%=post.getPostTitle()%></span>
							<p><%=post.getContent()%></p></li>
						<%
						}
						%>
					</ul>
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