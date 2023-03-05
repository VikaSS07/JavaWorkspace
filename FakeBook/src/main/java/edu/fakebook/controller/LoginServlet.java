package edu.fakebook.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.fakebook.entities.Post;
import edu.fakebook.entities.User;
import edu.fakebook.model.FriendsManager;
import edu.fakebook.model.PostManager;
import edu.fakebook.model.UserManager;
import edu.fakebook.utilities.Validate;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!Validate.validateUser(request)) {
			UserManager um = new UserManager();
			try {
				boolean result = um.userLogin(request, response);
				if (result) {
					PostManager pm = new PostManager();
					List<Post> posts = new ArrayList<Post>();
					posts = pm.getAllPosts();
					request.setAttribute("allposts", posts);
					//call suggested friends method and set attribute
					FriendsManager fm = new FriendsManager();
					ArrayList<User> userSuggestions= new ArrayList<User>();
					HttpSession session = request.getSession();
					User user = (User) session.getAttribute("user");
					
					userSuggestions = fm.getSuggestedFriends(user.getUserId());
					request.setAttribute("friendsSuggestion", userSuggestions);
//				response.sendRedirect("index.jsp");
					RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
					dis.forward(request, response);

				} else {
					response.sendRedirect("login.jsp?code=500");
				}
			} catch ( Exception e) {
				e.printStackTrace();
			}
		} else {
			PostManager pm = new PostManager();
			List<Post> posts = new ArrayList<Post>();
			try {
				posts = pm.getAllPosts();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("allposts", posts);
			//call suggested friends method and set attribute
			FriendsManager fm = new FriendsManager();
			ArrayList<User> userSuggestions= new ArrayList<User>();
			try {
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				
				userSuggestions = fm.getSuggestedFriends(user.getUserId());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("friendsSuggestion", userSuggestions);
			
//		response.sendRedirect("index.jsp");
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
		}
	}

}
