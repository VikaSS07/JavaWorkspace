package edu.fakebook.utilities;

import edu.fakebook.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Validate {
public static boolean validateUser(HttpServletRequest request) {
	boolean result = false;
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user!=null) {
		result = true;
	}
	return result;
}
}
