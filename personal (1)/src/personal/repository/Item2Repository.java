package personal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import personal.bean.Item2;

public class Item2Repository {

		private Connection con;

		public void setConnection(Object con) {
			this.con = (Connection) con;
		}
	
		public Item2 getItem(int id) {
			
			Item2 item = null;
			ResultSet rs = null;
			String sql = "SELECT id, title, body, created, user_id, file " 
					+ "FROM musiclist " + "WHERE id=?";
			
			try(PreparedStatement pstmt = con.prepareStatement(sql);) {
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					item = new Item2();
					item.setId2(id);
					item.setTitle2(rs.getString(2));
					item.setBody2(rs.getString(3));
					item.setCreated2(rs.getTimestamp(4));
					item.setUserId2(rs.getString(5));
					item.setFile2(rs.getString(6));
					
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

		public List<Item2> list() {
			String sql = "SELECT id, title, body, user_id, created " + "FROM musiclist ORDER BY id DESC";
			
			List<Item2> list = new ArrayList<>();
			
			try (
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					){
				while(rs.next()){
					Item2 item = new Item2();
					item.setId2(rs.getInt(1));
					item.setTitle2(rs.getString(2));
					item.setBody2(rs.getString(3));
					item.setUserId2(rs.getString(4));
					item.setCreated2(rs.getTimestamp(5));
					
					list.add(item);
				}
				
			} catch (Exception e){
				e.printStackTrace();
				
			}
			
			
			return list;
		}




		public boolean addItem(Item2 item) {
			String sql = "INSERT INTO musiclist (title, body, user_id, file) "
					+ "VALUES (?, ?, ?, ?)";
			
			ResultSet rs = null;
			
			try ( PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
				
				pstmt.setString(1, item.getTitle2());
				pstmt.setString(2, item.getBody2());
				pstmt.setString(3, item.getUserId2());
				pstmt.setString(4, item.getFile2());
				
				int count = pstmt.executeUpdate();
				
				if(count ==1) {
					rs = pstmt.getGeneratedKeys();
					if(rs.next()){
						item.setId2(rs.getInt(1));
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




		public boolean updateItem(Item2 item) {
			
			String sql = "UPDATE musiclist "
					+ "SET title=?, body=?, file=? "
					+ "WHERE id=?";
			
			try (
				PreparedStatement pstmt = con.prepareStatement(sql);
					) {
				pstmt.setString(1, item.getTitle2());
				pstmt.setString(2, item.getBody2());
				pstmt.setString(3, item.getFile2());
				pstmt.setInt(4, item.getId2());
				
				int count = pstmt.executeUpdate();
				
				if (count == 1) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			return false;
		}




		public void removeItem(Item2 item) {
			
			
			String sql = "DELETE FROM musiclist "
					+ "WHERE id=?";
			
			try(PreparedStatement pstmt = con.prepareStatement(sql);) {
				pstmt.setInt(1, item.getId2());
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
		}




		public List<Item2> list(int page) {
			int itemPerPage = 6;
			String sql = "SELECT id, title, body, user_id, created " 
					+ "FROM musiclist "
					+ "ORDER BY id DESC "
					+ "LIMIT ?, ?";

			List<Item2> list = new ArrayList<>();
			ResultSet rs = null;
			
			
			
			
			
			try (PreparedStatement pstmt = con.prepareStatement(sql);) {
				pstmt.setInt(1, (page - 1) * itemPerPage);
				pstmt.setInt(2, itemPerPage);
				
				rs = pstmt.executeQuery();

				while (rs.next()) {
					Item2 item = new Item2();
					item.setId2(rs.getInt(1));
					item.setTitle2(rs.getString(2));
					item.setBody2(rs.getString(3));
					item.setUserId2(rs.getString(4));
					item.setCreated2(rs.getTimestamp(5));
					
					
					

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
	


	
	
	
	
	

