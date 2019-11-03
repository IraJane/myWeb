package personal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import personal.bean.Comment2;

public class Comment2Repository {
	private Connection con;
	
	public void setConnection(Object con){
		this.con = (Connection) con;
	}

	public boolean addComment(Comment2 comment) {
		String sql = "INSERT INTO commenthoop "
				+ "(comment, item_id, user_id) "
				+ "VALUES (?, ?, ?)";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, comment.getComment2());
			pstmt.setInt(2, comment.getItemId2());
			pstmt.setString(3, comment.getUserId2());
			
			int count = pstmt.executeUpdate();
			
			if(count ==1) {
				return true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	public List<Comment2> list(int itemId) {
		List<Comment2> list = new ArrayList<>();
		String sql = "SELECT id, comment, item_id, user_id, created "
				+ "FROM commenthoop "
				+ "WHERE item_id=? "
				+ "ORDER BY id DESC";
		
		ResultSet rs = null;
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, itemId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Comment2 c = new Comment2();
				c.setId2(rs.getInt(1));
				c.setComment2(rs.getString(2));
				c.setItemId2(rs.getInt(3));
				c.setUserId2(rs.getString(4));
				c.setCreated2(rs.getTimestamp(5));
				
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}

	public void updateComment(Comment2 comment) {
		String sql = "UPDATE commenthoop "
				+ "SET comment=? "
				+ "WHERE id=? AND user_id=?";
		
		
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, comment.getComment2());
			pstmt.setInt(2, comment.getId2());
			pstmt.setString(3, comment.getUserId2());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	public void removeComment(int commentid, String user) {
		String sql = "DELETE FROM commenthoop "
				+ "WHERE id=? AND user_id=? ";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, commentid);
			pstmt.setString(2, user);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
