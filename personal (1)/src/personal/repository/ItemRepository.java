package personal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import personal.bean.Item;

public class ItemRepository {
	private Connection con;

	public void setConnection(Object con) {
		this.con = (Connection) con;
	}

	
	
	
	public Item getItem(int id) {
		
		Item item = null;
		ResultSet rs = null;
		String sql = "SELECT id, title, body, created, user_id, file " 
				+ "FROM booklist " + "WHERE id=?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				item = new Item();
				item.setId(id);
				item.setTitle(rs.getString(2));
				item.setBody(rs.getString(3));
				item.setCreated(rs.getTimestamp(4));
				item.setUserId(rs.getString(5));
				item.setFile(rs.getString(6));
				
			}
			return item;
			
			
		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		
		return item;
	}

	public List<Item> list() {
		String sql = "SELECT id, title, body, user_id, created " + "FROM booklist ORDER BY id DESC";
		
		List<Item> list = new ArrayList<>();
		
		try (
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){
			while(rs.next()){
				Item item = new Item();
				item.setId(rs.getInt(1));
				item.setTitle(rs.getString(2));
				item.setBody(rs.getString(3));
				item.setUserId(rs.getString(4));
				item.setCreated(rs.getTimestamp(5));
				
				list.add(item);
			}
			
		} catch (Exception e){
			e.printStackTrace();
			
		}
		
		
		return list;
	}




	public boolean addItem(Item item) {
		String sql = "INSERT INTO booklist (title, body, user_id, file) "
				+ "VALUES (?, ?, ?, ?)";
		
		ResultSet rs = null;
		
		try ( PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			
			pstmt.setString(1, item.getTitle());
			pstmt.setString(2, item.getBody());
			pstmt.setString(3, item.getUserId());
			pstmt.setString(4, item.getFile());
			
			int count = pstmt.executeUpdate();
			
			if(count ==1) {
				rs = pstmt.getGeneratedKeys();
				if(rs.next()){
					item.setId(rs.getInt(1));
				}
				return true;
			}
			
		} catch(Exception e){
			e.printStackTrace();
			
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		
		
		
		
		
		return false;
	}




	public boolean updateItem(Item item) {
		
		String sql = "UPDATE booklist "
				+ "SET title=?, body=?, file=? "
				+ "WHERE id=?";
		
		try (
			PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setString(1, item.getTitle());
			pstmt.setString(2, item.getBody());
			pstmt.setString(3, item.getFile());
			pstmt.setInt(4, item.getId());
			
			int count = pstmt.executeUpdate();
			
			if (count == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}




	public void removeItem(Item item) {
		
		
		String sql = "DELETE FROM booklist "
				+ "WHERE id=?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getId());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}




	public List<Item> list(int page) {
		int itemPerPage = 6;
		String sql = "SELECT id, title, body, user_id, created " 
				+ "FROM booklist "
				+ "ORDER BY id DESC "
				+ "LIMIT ?, ?";

		List<Item> list = new ArrayList<>();
		ResultSet rs = null;
		
		
		
		
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, (page - 1) * itemPerPage);
			pstmt.setInt(2, itemPerPage);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt(1));
				item.setTitle(rs.getString(2));
				item.setBody(rs.getString(3));
				item.setUserId(rs.getString(4));
				item.setCreated(rs.getTimestamp(5));
				
				
				

				list.add(item);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
