package edu.fakebook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
