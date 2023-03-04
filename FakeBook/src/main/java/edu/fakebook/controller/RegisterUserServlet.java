package edu.fakebook.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import edu.fakebook.entities.User;
import edu.fakebook.model.UserManager;
import edu.fakebook.utilities.CommonUtility;

@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterUserServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setName(request.getParameter("firstName") + " " + request.getParameter("lastName"));
		user.setUserName(request.getParameter("email"));
		user.setPhoneNo(request.getParameter("phoneNumber"));
		if (request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
			user.setPassword(request.getParameter("password"));
			user.setDateOfBirth(request.getParameter("dob"));
			UserManager um = new UserManager();
			try {
				Boolean result = um.newUser(user);
				if (result) {
					response.sendRedirect("login.jsp?code=200");
				} else {
					response.sendRedirect("login.jsp?code=501");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("login.jsp?code=501");
			}
		} else {
			response.sendRedirect("register.jsp?code=500");
		}

	}

}
