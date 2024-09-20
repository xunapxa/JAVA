package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import crudInterface.CRUDInterface;
import db.DBConn;
import entity.Product;
import entity.User;

public class VMachineDAO implements CRUDInterface {

	@Override
	public int insertUser(User user) {
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO user(u_id, u_pw, u_name, u_tel, u_cash, u_sum, insert_date)" +
						"VALUES(?,?,?,?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getU_id());
			psmt.setString(2, user.getU_pw());
			psmt.setString(3, user.getU_name());
			psmt.setString(4, user.getU_tel());
			psmt.setInt(5, user.getU_cash());
			psmt.setInt(6, user.getU_sum());
			psmt.setTimestamp(7, Timestamp.valueOf(user.getInsertedDate()));
			
			result = psmt.executeUpdate();
			psmt.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Long u_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> userAll() {
		List<User> users = new ArrayList<User>();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM user";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setU_num(rs.getLong("u_num"));
				user.setU_id(rs.getString("u_id"));
				user.setU_pw(rs.getString("u_pw"));
				user.setU_name(rs.getString("u_name"));
				user.setU_tel(rs.getString("u_tel"));
				user.setU_cash(rs.getInt("u_cash"));
				user.setU_sum(rs.getInt("u_sum"));
				user.setInsertedDate(rs.getTimestamp("insert_date").toLocalDateTime());
				if (rs.getTimestamp("update_date") != null) {
					user.setUpdatedDate(rs.getTimestamp("update_date").toLocalDateTime());
				} else {
					user.setUpdatedDate(null);
				}
				users.add(user);
			}
			
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return users;
	}

	@Override
	public int insertPro(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePro(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePro(Long p_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> productAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> userSelAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> proSelAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserId(Long u_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findID(String u_id) {
		return null;
	}

	@Override
	public int findPW(String u_pw) {
		// TODO Auto-generated method stub
		return 0;
	}

}
