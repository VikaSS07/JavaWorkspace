package edu.fakebook.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.mysql.cj.Session;

import edu.fakebook.entities.Post;
import edu.fakebook.entities.User;
import edu.fakebook.model.PostManager;
import edu.fakebook.model.UserManager;
import edu.fakebook.utilities.CommonUtility;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
@WebServlet("/newpost")
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewPostServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		Post post = new Post();
		post.setPostTitle(request.getParameter("title"));
		String PicPath = CommonUtility.saveImage("posts", "", request);
		if (PicPath != null) {
			PicPath = "./images/posts/" + PicPath;
			post.setImagePath(PicPath);
			post.setContent(request.getParameter("content"));
			post.setUser(user);
		}
		PostManager pm = new PostManager();
		try {
			boolean result = pm.newPost(post,request);
			if (result) {
				response.sendRedirect("newpost.jsp?code=200");
			} else {
				response.sendRedirect("newpost.jsp?code=500");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
