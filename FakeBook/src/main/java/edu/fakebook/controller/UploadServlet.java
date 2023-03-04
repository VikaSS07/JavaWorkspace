package edu.fakebook.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out1 = response.getWriter()) {
			HttpSession session = request.getSession();
			String name = request.getParameter("unname");
			Part filePart = request.getPart("filecover");

			String photo = "";
			String path = "C:\\Users\\surya\\eclipse-workspace\\Advanced-Java\\FakeBook\\src\\main\\webapp\\images\\userProfiles";

			File file = new File(path);
			file.mkdir();
			String fileName = getFileName(filePart);

			OutputStream out = null;

			InputStream filecontent = null;

			PrintWriter writer = response.getWriter();
			try {
				out = new FileOutputStream(new File(path + File.separator + fileName));

				filecontent = filePart.getInputStream();

				int read = 0;
				final byte[] bytes = new byte[1024];

				while ((read = filecontent.read(bytes)) != -1) {
					out.write(bytes, 0, read);

					photo = path + "/" + fileName;

				}

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
				Statement stmt = con.createStatement();

				stmt.executeUpdate("insert into test(Name,photourl) values('" + name + "','" + photo + "')");

			} catch (Exception e) {

			}
			out1.println(
					"<html><body><script>alert('Sucessfully Saved! Check the database and the path!');</script></body></html>");
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
