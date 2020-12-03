package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReviewDAO {

	public static int postReview(Connection con, ReviewVO review) {

		String query = "INSERT INTO review(user_idx, class_idx, content, user_name) VALUES (?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, review.getUserIdx());
			ps.setInt(2, review.getClassIdx());
			ps.setString(3, review.getContent());
			ps.setString(4, review.getUserName());

			int i = ps.executeUpdate();

			if (i == 1) {
				return i;
			} else {
				return 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static ArrayList<ReviewVO> getReview(Connection con, int classIdx) {
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		String query = "SELECT * FROM review WHERE class_idx=" + classIdx;

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				ReviewVO review = new ReviewVO();
				review.setReviewIdx(rs.getInt(1));
				review.setClassIdx(rs.getInt(3));
				review.setContent(rs.getString(4));
				review.setUserName(rs.getString(5));
				list.add(review);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
