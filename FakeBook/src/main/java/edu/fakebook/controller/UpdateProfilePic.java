package edu.fakebook.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import edu.fakebook.model.UserManager;
import edu.fakebook.utilities.CommonUtility;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
@WebServlet("/updateprofilepic")
public class UpdateProfilePic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProfilePic() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String PicPath = CommonUtility.saveImage("userProfiles", "", request);
		if (PicPath != null) {
			PicPath = "./images/userProfiles/" + PicPath;
		}
		UserManager um = new UserManager();
		try {
			boolean result = um.updateProfile(PicPath, request);
			if (result) {
				response.sendRedirect("UserProfile.jsp?code=200");
			} else {
				response.sendRedirect("UserProfile.jsp?code=500");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
