package com.session.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static ResultSet findUser(Connection con, String mid) {
		String sqlSt = "SELECT passwd FROM member WHERE memid=";
		Statement st;
		try {
			st = con.createStatement();
			if (st.execute(sqlSt + "'" + mid + "'")) {
				return st.getResultSet();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
