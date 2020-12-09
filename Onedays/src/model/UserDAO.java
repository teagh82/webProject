package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

import javax.swing.JOptionPane;

public class UserDAO {

	private static UserDAO instance;

	public static UserDAO getInstance() {
		if (instance == null)
			instance = new UserDAO();
		return instance;
	}

	public static ResultSet getAllUser(Connection con) {

		String sqlSt = "SELECT * FROM user";
		Statement st;

		try {
			st = con.createStatement();

			if (st.execute(sqlSt)) {
				return st.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet login(Connection con, String id) {

		String sqlSt = "SELECT user_idx, password, region FROM user WHERE id=";
		Statement st;

		try {
			st = con.createStatement();

			if (st.execute(sqlSt + "'" + id + "'")) {
				return st.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet duplicateCheck(Connection con, String id) {

		String sqlSt = "SELECT password FROM user WHERE id=";
		Statement st;

		try {
			st = con.createStatement();

			if (st.execute(sqlSt + "'" + id + "'")) {
				return st.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int join(Connection con, String id, String password, String email, String name, String phone_number,
			int region) {

		String query = "INSERT INTO user(id, email, password, name, phone_number, region) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, id);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, name);
			ps.setString(5, phone_number);
			ps.setInt(6, region);
			int i = ps.executeUpdate();

			if (i == 1) { // 업데이트 성공
				System.out.println(i + " " + "join 성공");
				return i;
			} else {
				System.out.println(i + " " + "join 실패");
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int updateUserInfo(Connection con, String id, String password, String name, String phone,
			String email, int region, int user_idx) {
		String query = "UPDATE user SET id = ?, password = ?, name = ?, phone_number = ?, email = ?, region = ? WHERE user_idx = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			System.out.println(id + " " + password + " " + name + " " + email + " " + phone + " " + region);

			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, phone);
			ps.setString(5, email);
			ps.setInt(6, region);
			ps.setInt(7, user_idx);
			int i = ps.executeUpdate();

			if (i == 1) { // 업데이트 성공
				System.out.println(i + " " + "updateUserInfo 성공");
				return i;
			} else {
				System.out.println(i + " " + "updateUserInfo 실패");
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 회원 정보 가져오기
	public UserVO getData(Connection con, String id) {

		UserVO vo = new UserVO();

		try {

			String query = "select id, email, password, name, phone_number from user where id=? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setEmail(rs.getString("email"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setPhoneNumber(rs.getString("phone_number"));

				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;

	}

	public static int updateUserLikeCategory(Connection con, int n, int user_idx) {
		String query = String.format("UPDATE user SET like_category = %d WHERE user_idx = %d", n, user_idx);
		try {
			PreparedStatement ps = con.prepareStatement(query);
			int i = ps.executeUpdate();

			if (i == 1) { // 업데이트 성공
				System.out.println(i + " " + "like category update 성공");
				return i;
			} else {
				System.out.println(i + " " + "like category update 실패");
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
}