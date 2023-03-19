<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UploadServlet" method="POST"
		enctype="multipart/form-data">
		<br>
		<h1> test</h1>
		<br>
		<table>
			<tr>
				<td>UserName:</td>
				<td width='10px'></td>
				<td><input type="text" name="unname" /></td>
			</tr>

			<tr>
				<td>Upload:</td>
				<td width='10px'></td>
				<td><input type="file" name="filecover" value="Upload" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
