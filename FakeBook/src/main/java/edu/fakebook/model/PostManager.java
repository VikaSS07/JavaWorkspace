package edu.fakebook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.fakebook.entities.Post;
import edu.fakebook.entities.User;
import edu.fakebook.utilities.JdbcConnection;
import jakarta.servlet.http.HttpServletRequest;

public class PostManager {
	public boolean newPost(Post post, HttpServletRequest request) throws SQLException {
		boolean result = false;
		Connection con = JdbcConnection.getConnection();
		String query = "INSERT INTO posts( posttitle, imagepath, content, userid) VALUES (?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, post.getPostTitle());
		pstmt.setString(2, post.getImagePath());
		pstmt.setString(3, post.getContent());
		pstmt.setInt(4, post.getUser().getUserId());
		int res = pstmt.executeUpdate();
		if (res != 0) {
			result = true;
			User user = (User) request.getSession().getAttribute("user");
			List<Post> posts = user.getPosts();
			posts.add(post);
			user.setPosts(posts);
			request.getSession().setAttribute("user", user);
		}
		return result;
	}

	public List<Post> getPosts(int userid) throws SQLException {
		List<Post> posts = new ArrayList<Post>();
		Connection con = JdbcConnection.getConnection();
		String query = "select * from posts where userid = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, userid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Post post = new Post();
			User user = new User();
			user.setUserId(rs.getInt("userid"));
			post.setPostId(rs.getInt("postid"));
			post.setPostTitle(rs.getString("posttitle"));
			post.setContent(rs.getString("content"));
			post.setImagePath(rs.getString("imagepath"));
			post.setUser(user);
			posts.add(post);

		}
		return posts;
	}
	public List<Post> getAllPosts() throws SQLException {
		List<Post> posts = new ArrayList<Post>();
		Connection con = JdbcConnection.getConnection();
		String query = "select * from posts inner join users on posts.userid = users.userid";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Post post = new Post();
			User user = new User();
			user.setUserId(rs.getInt("users.userid"));
			user.setName(rs.getString("users.name"));
			user.setImagePath(rs.getString("users.imagepath"));
			post.setPostId(rs.getInt("posts.postid"));
			post.setPostTitle(rs.getString("posts.posttitle"));
			post.setContent(rs.getString("posts.content"));
			post.setImagePath(rs.getString("posts.imagepath"));
			post.setUser(user);
			posts.add(post);

		}
		return posts;
	}
}
