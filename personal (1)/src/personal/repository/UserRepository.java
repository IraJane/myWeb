package personal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import personal.bean.Members;

public class UserRepository {
	private Connection con;
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public void setConnection(Object con) {
		this.con = (Connection) con;
	}


	public Members getUser(String id, String pw) {
		
		String sql = "SELECT id, password, nickname "
				+ "FROM members "
				+ "WHERE id=? "
				+ "AND password=?";
		
			ResultSet rs = null;
		

			try (
					PreparedStatement stmt = con.prepareStatement(sql);
				) {
			
				stmt.setString(1, id);
				stmt.setString(2, pw);
			
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					Members user = new Members();
					String rsid = rs.getString(1);
					String rspw = rs.getString(2);
					String rsnick = rs.getString(3);
					
				
					
					user.setUser(rsid);
					user.setPassword(rspw);
					user.setNickName(rsnick);
					
					
				return user;
				
			
			} else {
				return null;
			}
			
		} catch (Exception e) {
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
		
		
		return null;
	}

	public boolean addUser(Members member) {
		String sql = "INSERT INTO members (id, password, nickname) "
				+ "VALUES (?, ?, ?)";
		
		System.out.println(sql);
		
		
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			
			stmt.setString(1, member.getUser());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getNickName());
			
			
			int count = stmt.executeUpdate();
			if (count == 1) {
				return true;
			} else {
				return false;
			}
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

	public boolean removeUser(Members member) {
		String sql = "DELETE FROM members "
				+ "WHERE id=? AND password=?";
		
		System.out.println(sql);
		
		try(	PreparedStatement stmt = con.prepareStatement(sql);
				){
			stmt.setString(1, member.getUser());
			stmt.setString(2, member.getPassword());
			
			int count = stmt.executeUpdate();
			if(count == 1) {
				return true;
			} else {
				return false;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	public boolean updateMember(Members origin, Members target) {
		String sql = "UPDATE members "
				+ "SET "
				+ "id=?, "
				+ "password=?, "
				+ "nickname=? "
				+ "WHERE id=? AND "
				+ "password=?";
				
		
		System.out.println(sql);
		
		try(PreparedStatement stmt = con.prepareStatement(sql);){
			stmt.setString(1, target.getUser());
			stmt.setString(2, target.getPassword());
			stmt.setString(3, target.getNickName());
			
			stmt.setString(4, origin.getUser());
			stmt.setString(5, origin.getPassword());
			
			
			int count = stmt.executeUpdate();
			
			if(count == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		
		
		
		return false;
	}
	
}
