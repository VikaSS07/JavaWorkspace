package edu.fakebook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.fakebook.entities.User;
import edu.fakebook.utilities.JdbcConnection;

public class FriendsManager {
	public boolean addFriend(int userid,int friendid) throws SQLException {
		boolean result = false;
		Connection con = JdbcConnection.getConnection();
		if(con!=null) {
			String query = "insert into friends(userid,friendid,status) values(?,?,'pending')";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userid);
			pstmt.setInt(2, friendid);
			int res = pstmt.executeUpdate();
			if(res!=0) {
				result = true;
			}
		}
		return result;
	}
	// add method suggested friends
	public ArrayList<User> getSuggestedFriends(int id) throws Exception {
		ArrayList<User> userList = new ArrayList<User>();
		
		Connection con = JdbcConnection.getConnection();
		if(con!=null) {
			
			// select name, imagepath from users where userid <> ? and userid not in (SELECT friendid FROM `friends` WHERE status= 'accepted' and userid = ?)
			//select * FROM users as u left OUTER JOIN friends as f on f.friendid = u.userid WHERE (f.status <> 'accepted' or f.userid is null) and u.userid<>2;
			//select * from users left OUTER join friends on friends.friendid =users.userid where users.userid <> 2 and users.userid not in (SELECT friendid FROM `friends` WHERE status= 'accepted' and userid = 2);
			String query = "select * FROM users as u left OUTER JOIN friends as f on f.friendid = u.userid WHERE (f.status <> 'accepted' or f.userid is null) and u.userid<>?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setUserId(rs.getInt("u.userid"));
				user.setName(rs.getString("u.name"));
				user.setImagePath(rs.getString("u.imagepath"));
				user.setFriendshipStatus(rs.getString("f.status"));
				userList.add(user);
			}
			
		}
		
		return userList;
	} 
	
}
