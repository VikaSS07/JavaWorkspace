package edu.fakebook.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.fakebook.entities.User;
import edu.fakebook.utilities.JdbcConnection;
import edu.fakebook.utilities.Validate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserManager {
	public boolean userLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		boolean result = false;

		if (!Validate.validateUser(request)) {
			Connection con = JdbcConnection.getConnection();
			if (con != null) {
				String query = "select * from users where username =? and password =? limit 1";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, request.getParameter("username"));
				pstmt.setString(2, request.getParameter("password"));
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					PostManager pm = new PostManager();
					result = true;
					User user = new User();
					user.setUserId(rs.getInt("userid"));
					user.setUserName(request.getParameter("username"));
					user.setName(rs.getString("name"));
					user.setBio(rs.getString("bio"));
					user.setPhoneNo(rs.getString("phoneno"));
					user.setDateOfBirth(rs.getString("dateofbirth"));
					user.setStatus(rs.getString("status"));
					user.setStudiedAt(rs.getString("studiedat"));
					user.setImagePath(rs.getString("imagepath"));
					user.setPosts(pm.getPosts(user.getUserId()));
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
				}
			}
		} else {
			result = true;
		}
		return result;
	}

	public boolean newUser(User user) throws SQLException {
		boolean result = false;
		Connection con = JdbcConnection.getConnection();
		String query = "INSERT INTO users(username, password, name, phoneno, dateofbirth,imagepath ) VALUES (?,?,?,?,?,'N/A')";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getPhoneNo());
		pstmt.setString(5, user.getDateOfBirth());
		int res = pstmt.executeUpdate();
		if (res != 0) {
			result = true;
		}
		return result;
	}

	public boolean updateProfile(String picPath, HttpServletRequest request) throws SQLException {
		boolean result = false;
		User user = (User) request.getSession().getAttribute("user");
		Connection con = JdbcConnection.getConnection();
		String query = "update users set imagepath = ? where username = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, picPath);
		pstmt.setString(2, user.getUserName());
		int res = pstmt.executeUpdate();
		if (res != 0) {
			result = true;
			user.setImagePath(picPath);
			request.getSession().setAttribute("user", user);
		}
		return result;
	}

}