package edu.fakebook.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;


public class CommonUtility {
	public static String saveImage(String location, String filename, HttpServletRequest request)
			throws IOException, ServletException {
		String result = null;
		Part filePart = request.getPart("filecover");

		String photo = "";
		String path = "C:\\Users\\surya\\eclipse-workspace\\Advanced-Java\\FakeBook\\src\\main\\webapp\\images\\"
				+ location;

		File file = new File(path);
		file.mkdir();
		String fileName = CommonUtility.getFileName(filePart);

		OutputStream out = null;

		InputStream filecontent = null;
		try {
			out = new FileOutputStream(new File(path + File.separator + fileName));

			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);

				photo = path + "/" + fileName;

			}

//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
//			Statement stmt = con.createStatement();
//
//			stmt.executeUpdate("insert into test(Name,photourl) values('" + name + "','" + photo + "')");
			result = fileName;
		} catch (Exception e) {

		}
		return result;
	}

	private static String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
