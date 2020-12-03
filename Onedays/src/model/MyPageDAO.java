package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MyPageDAO {

	Connection con;
	Statement st;
	ResultSet rs;
	String url = "jdbc:mysql://onedays.cq2qma9rqvji.us-east-2.rds.amazonaws.com/onedays";

	public MyPageDAO() {
		try {
			// 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 연결
			con = DriverManager.getConnection(url, "admin", "sungshin");

		} catch (ClassNotFoundException e) {
			System.out.println(e + "=> 로드 실패");
		} catch (SQLException e) {
			System.out.println(e + "=> 연결 실패");
		}
	}// ClassDAO()

	// 내가 만든 클래스 목록 가져오기
	public ArrayList<ClassVO> getMyRegistClass(int userIdx) {
		ArrayList<ClassVO> list = new ArrayList<ClassVO>();

		String query = String.format(
				"SELECT name, price, image, class_region_idx, class_idx FROM class WHERE user_idx=\"%s\"", userIdx);
		System.out.println(query);
		try {// 실행
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				ClassVO vo = new ClassVO();

				vo.setName(rs.getString(1));
				vo.setPrice(rs.getInt(2));
				vo.setImage(rs.getString(3));
				vo.setClassRegionIdx(rs.getInt(4));
				vo.setClassIdx(rs.getInt(5));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e + "=> getMyRegistClass fail");
		}
		return list;
	}

	// 내가 신청한 클래스
	public ArrayList<ClassVO> getMyApplicationClass(int userIdx) {
		ArrayList<ClassVO> list = new ArrayList<ClassVO>();

		String query = String.format("SELECT class_idx FROM application WHERE user_idx=\"%s\"", userIdx);
		String query2 = String.format(
				"SELECT name, price, image, class_region_idx, class_idx FROM class WHERE class_idx IN (%s) AND date >= curdate()",
				query);
		System.out.println(query2);
		try {// 실행
			st = con.createStatement();
			rs = st.executeQuery(query2);

			while (rs.next()) {
				ClassVO vo = new ClassVO();

				vo.setName(rs.getString(1));
				vo.setPrice(rs.getInt(2));
				vo.setImage(rs.getString(3));
				vo.setClassRegionIdx(rs.getInt(4));
				vo.setClassIdx(rs.getInt(5));
				list.add(vo);

			}
		} catch (Exception e) {
			System.out.println(e + "=> getMyRegistClass fail");
		}
		return list;
	}

	// 수강 완료 클래스
	public ArrayList<ClassVO> getCompleteMyApplicationClass(int userIdx) {
		ArrayList<ClassVO> list = new ArrayList<ClassVO>();

		String query = String.format("SELECT class_idx FROM application WHERE user_idx=\"%s\"", userIdx);
		String query2 = String.format(
				"SELECT name, price, image, class_region_idx, class_idx FROM class WHERE class_idx IN (%s) AND date < curdate()",
				query);
		System.out.println(query2);
		try {// 실행
			st = con.createStatement();
			rs = st.executeQuery(query2);

			while (rs.next()) {
				ClassVO vo = new ClassVO();

				vo.setName(rs.getString(1));
				vo.setPrice(rs.getInt(2));
				vo.setImage(rs.getString(3));
				vo.setClassRegionIdx(rs.getInt(4));
				vo.setClassIdx(rs.getInt(5));
				list.add(vo);

			}
		} catch (Exception e) {
			System.out.println(e + "=> getMyRegistClass fail");
		}
		return list;
	}

	// 내가 관심있는 클래스
	public ArrayList<ClassVO> getMyFavClass(int userIdx) {
		ArrayList<ClassVO> list = new ArrayList<ClassVO>();

		String query = String.format("SELECT class_idx FROM `like` WHERE user_idx=\"%s\"", userIdx);
		String query2 = String.format(
				"SELECT name, price, image, class_region_idx, class_idx FROM class WHERE class_idx IN (%s)", query);
		System.out.println(query2);
		try {// 실행
			st = con.createStatement();
			rs = st.executeQuery(query2);

			while (rs.next()) {
				ClassVO vo = new ClassVO();

				vo.setName(rs.getString(1));
				vo.setPrice(rs.getInt(2));
				vo.setImage(rs.getString(3));
				vo.setClassRegionIdx(rs.getInt(4));
				vo.setClassIdx(rs.getInt(5));
				list.add(vo);

			}
		} catch (Exception e) {
			System.out.println(e + "=> getMyFavClass fail");
		}
		return list;
	}

}
