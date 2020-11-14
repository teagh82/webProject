package model;

import java.sql.*;

public class DBUtil {
	
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

	public static ResultSet login(Connection con, String email) {

		String sqlSt = "SELECT password FROM user WHERE email=";
		Statement st;

		try {
			st = con.createStatement();

			if (st.execute(sqlSt + "'" + email + "'")) {
				return st.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int join(Connection con, String email, String password, String name, String phone_number, boolean is_teacher) {

		String query = "INSERT INTO user(email, password, name, phone_number, is_teacher) VALUES(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, phone_number);
			ps.setBoolean(5, is_teacher);
			int i = ps.executeUpdate();
			
			System.out.println(i);
			
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
}