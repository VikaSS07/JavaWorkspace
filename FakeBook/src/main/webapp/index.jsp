<%@page import="java.util.ArrayList"%>
<%@page import="edu.fakebook.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="edu.fakebook.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="edu.fakebook.utilities.Validate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FakeBook</title>
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
	<!-- Header Section -->
	<header class="container-fluid bg-light py-5" style="margin-top: 40px">
		<div class="row justify-content-center">
			<div class="col-md-8 text-center">
				<h1>
					Welcome to FakeBook
					<%=user.getName()%></h1>
				<p class="lead">Connect with friends and family, share photos
					and videos, and stay updated on what's happening in the world.</p>
				<form>
					<div class="form-group">
						<input type="text" class="form-control"
							placeholder="Search for friends or topics">
					</div>
					<button type="submit" class="btn btn-primary">Search</button>
				</form>
			</div>
		</div>
	</header>
	<main class="container-fluid">
		<div class="row">
			<div class="col-md-9">
				<div>
					<div class="card-body">
						<h5 class="card-title">Recent Posts</h5>
						<%
						List<Post> posts = (ArrayList<Post>) request.getAttribute("allposts");
						if (posts != null) {
							for (Post post : posts) {
						%>
						<div class="bg-white border mt-2">
							<div>
								<div
									class="d-flex flex-row justify-content-between align-items-center p-2 border-bottom">
									<div class="d-flex flex-row align-items-center feed-text px-2">
										<img class="rounded-circle"
											src="<%=post.getUser().getImagePath()%>" width="45">
										<div class="d-flex flex-column flex-wrap ml-2">
											<span class="font-weight-bold"><%=post.getUser().getName()%></span><span
												class="text-black-50 time">40 minutes ago</span>
										</div>
									</div>
									<div class="feed-icon px-2">
										<i class="fa fa-ellipsis-v text-black-50"></i>
									</div>
								</div>
							</div>
							<div class="p-2 px-3">
								<span style="font-weight: bold;"><%=post.getPostTitle()%></span><br>
								<img src="<%=post.getImagePath()%>" class="img-thumbnail"
									width="420" height="250">
								<p>
									<span><%=post.getContent()%></span>
								</p>
							</div>
							<div class="d-flex justify-content-end socials p-2 py-3">
								<i class="fa fa-thumbs-up"></i><i class="fa fa-comments-o"></i><i
									class="fa fa-share"></i>
							</div>
						</div>
						<%
						}
						} else {
						response.sendRedirect("login");
						}
						%>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Suggested Friends</h5>
						<ul class="list-group">
							<%
							ArrayList<User> suggestedFriends = (ArrayList<User>) request.getAttribute("friendsSuggestion");
							if (suggestedFriends != null) {

								for (User friend : suggestedFriends) {
							%>
							<li class="list-group-item"><%=friend.getName()%>
								<p class="text-right">
									<a href="addFriend?id=<%=friend.getUserId()%>">Send Request</a>
								</p></li>

							<%
							}
							}
							%>


						</ul>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Suggested Friends</h5>
						<ul class="list-group">
							<%
							//ArrayList<User> suggestedFriends = (ArrayList<User>) request.getAttribute("friendsSuggestion");
							if (suggestedFriends != null) {

								for (User friend : suggestedFriends) {
							%>
							<li class="list-group-item"><%=friend.getName()%>
								<p class="text-right">
									<a href="addFriend?id=<%=friend.getUserId()%>">Send Request</a>
								</p></li>

							<%
							}
							}
							%>


						</ul>
					</div>
				</div>
			</div>
		</div>
	</main>


	<%@ include file="bootstrapJsCss.jsp"%>
</body>
</html>
<%
}
%>