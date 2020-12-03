package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class ClassDAO {

	Connection con;
	Statement st;
	ResultSet rs;
	String url = "jdbc:mysql://onedays.cq2qma9rqvji.us-east-2.rds.amazonaws.com/onedays";

	public ClassDAO() {
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

	public static int postClass(Connection con, ClassVO inputClass) {
		String query = "INSERT INTO class(category_idx, class_region_idx, name, date, time, place, price, level, "
				+ "people, apply_people, content, teacher_info, image, user_idx) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, inputClass.getCategoryIdx());
			ps.setInt(2, inputClass.getClassRegionIdx());
			ps.setString(3, inputClass.getName());
			ps.setString(4, inputClass.getDate());
			ps.setString(5, inputClass.getTime());
			ps.setString(6, inputClass.getPlace());
			ps.setInt(7, inputClass.getPrice());
			ps.setString(8, inputClass.getLevel());
			ps.setInt(9, inputClass.getPeople());
			ps.setInt(10, inputClass.getApplyPeople());
			ps.setString(11, inputClass.getContent());
			ps.setString(12, inputClass.getTeacherInfo());
			ps.setString(13, inputClass.getImage());
			ps.setInt(14, inputClass.getUserIdx());

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
	

	public static ClassVO getClassByIdx(Connection con, int idx) {
		String query = "SELECT * FROM class WHERE class_idx = " + idx;

		try {
			Statement st = con.createStatement();
			if (st.execute(query)) {
				ResultSet rs = st.getResultSet();

				while (rs.next()) {
					ClassVO c = new ClassVO();
					c.setClassIdx(rs.getInt("class_idx"));
					c.setCategoryIdx(rs.getInt("category_idx"));
					c.setClassRegionIdx(rs.getInt("class_region_idx"));
					c.setName(rs.getString("name"));
					c.setDate(rs.getString("date"));
					c.setTime(rs.getString("time"));
					c.setLevel(rs.getString("level"));
					c.setPlace(rs.getString("place"));
					c.setPrice(rs.getInt("price"));
					c.setPeople(rs.getInt("people"));
					c.setApplyPeople(rs.getInt("apply_people"));
					c.setContent(rs.getString("content"));
					c.setImage(rs.getString("image"));
					c.setTeacherInfo(rs.getString("teacher_info"));
					c.setUserIdx(rs.getInt("user_idx"));
					return c;
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// 추천 클래스 보여주기 위함
	public ArrayList<ClassVO> getRecomendlist() {
		ArrayList<ClassVO> list = new ArrayList<ClassVO>();

		String query1 = "SELECT like_category FROM USER";
		String query2 = "SELECT * FROM class where is_closed = 0 ORDER BY RAND() LIMIT 4 ";

		try {// 실행
			st = con.createStatement();
			rs = st.executeQuery(query2);

			while (rs.next()) {
				ClassVO vo = new ClassVO();

				vo.setClassIdx(rs.getInt(1));
				vo.setCategoryIdx(rs.getInt(2));
				vo.setClassRegionIdx(rs.getInt(3));
				vo.setName(rs.getString(4));
				vo.setDate(rs.getString(5));
				vo.setPlace(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setLevel(rs.getString(9));
				vo.setImage(rs.getString(14));

				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e + "=> getRecomendlist fail");
		}
		return list;
	}// getRecomendlist

	// 인기 클래스 보여주기
	public ArrayList<ClassVO> getPopularlist() {
		ArrayList<ClassVO> list = new ArrayList<ClassVO>();

		String query = "SELECT * FROM class INNER JOIN (select class_idx, COUNT(like_idx) AS cnt "
				+ "FROM `like` group by class_idx) AS cnt ON class.class_idx = cnt.class_idx ORDER BY cnt.cnt DESC LIMIT 4";

		try {// 실행
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				ClassVO vo = new ClassVO();

				vo.setClassIdx(rs.getInt(1));
				vo.setCategoryIdx(rs.getInt(2));
				vo.setClassRegionIdx(rs.getInt(3));
				vo.setName(rs.getString(4));
				vo.setDate(rs.getString(5));
				vo.setPlace(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setImage(rs.getString(14));

				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e + "=> getPopularlist fail");
		}
		return list;
	}// getPopularlist

	// 마감임박 클래스 보여주기
	public ArrayList<ClassVO> getEndlist() {
		ArrayList<ClassVO> list = new ArrayList<ClassVO>();

		String query = "SELECT *, people - apply_people as sub FROM class ORDER BY sub LIMIT 4";

		try {// 실행
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				ClassVO vo = new ClassVO();

				vo.setClassIdx(rs.getInt(1));
				vo.setCategoryIdx(rs.getInt(2));
				vo.setClassRegionIdx(rs.getInt(3));
				vo.setName(rs.getString(4));
				vo.setDate(rs.getString(5));
				vo.setPlace(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setImage(rs.getString(14));

				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e + "=> getEndlist fail");
		}
		return list;
	}// getEndlist
	
	// 사용자가 설정한 지역 클래스 보여주기
		public ArrayList<ClassVO> getRegionlist(Object ur) {
			ArrayList<ClassVO> list = new ArrayList<ClassVO>();
		
			String query = "SELECT * from class where"+" is_closed = 0 AND"+" class_region_idx = "+ ur +" ORDER BY RAND() LIMIT 4";

			try {// 실행
				st = con.createStatement();
				rs = st.executeQuery(query);

				while (rs.next()) {
					ClassVO vo = new ClassVO();

					vo.setClassIdx(rs.getInt(1));
					vo.setCategoryIdx(rs.getInt(2));
					vo.setClassRegionIdx(rs.getInt(3));
					vo.setName(rs.getString(4));
					vo.setDate(rs.getString(5));
					vo.setPlace(rs.getString(7));
					vo.setPrice(rs.getInt(8));
					vo.setImage(rs.getString(14));

					list.add(vo);
				}
			} catch (Exception e) {
				System.out.println(e + "=> getRegionlist fail");
			}
			return list;
		}// getRegionlist
		
		// 좋아요 클래스 보여주기
		public ArrayList<ClassVO> getLikelist(Object uid) {
			ArrayList<ClassVO> list = new ArrayList<ClassVO>();

			String query = "SELECT * from class INNER JOIN `like` on class.class_idx = like.class_idx where "+"is_closed = 0 AND"+" `like`.user_idx = "+uid+" ORDER BY RAND() LIMIT 4";

			try {// 실행
				st = con.createStatement();
				rs = st.executeQuery(query);

				while (rs.next()) {
					ClassVO vo = new ClassVO();

					vo.setClassIdx(rs.getInt(1));
					vo.setCategoryIdx(rs.getInt(2));
					vo.setClassRegionIdx(rs.getInt(3));
					vo.setName(rs.getString(4));
					vo.setDate(rs.getString(5));
					vo.setPlace(rs.getString(7));
					vo.setPrice(rs.getInt(8));
					vo.setImage(rs.getString(14));

					list.add(vo);
				}
			} catch (Exception e) {
				System.out.println(e + "=> getEndlist fail");
			}
			return list;
		}// getLikelist
		
		// 신청한 클래스 기반 추천 클래스 보여주기
		public ArrayList<ClassVO> getApplylist(Object uid) {
			ArrayList<ClassVO> list = new ArrayList<ClassVO>();

			String query = "SELECT * from class INNER JOIN application on class.class_idx = application.class_idx where "+"is_closed = 0 AND "+"application.user_idx = "+uid+" ORDER BY RAND() LIMIT 4";

			try {// 실행
				st = con.createStatement();
				rs = st.executeQuery(query);

				while (rs.next()) {
					ClassVO vo = new ClassVO();

					vo.setClassIdx(rs.getInt(1));
					vo.setCategoryIdx(rs.getInt(2));
					vo.setClassRegionIdx(rs.getInt(3));
					vo.setName(rs.getString(4));
					vo.setDate(rs.getString(5));
					vo.setPlace(rs.getString(7));
					vo.setPrice(rs.getInt(8));
					vo.setImage(rs.getString(14));

					list.add(vo);
				}
			} catch (Exception e) {
				System.out.println(e + "=> getEndlist fail");
			}
			return list;
		}// getApplylist

	// 카테고리로 클래스 검색
		public ArrayList<ClassVO> getCategorylist(int category_idx) {
			ArrayList<ClassVO> list = new ArrayList<ClassVO>();
			
			String query = "SELECT * FROM class WHERE category_idx = " + category_idx+" AND is_closed = 0";

			try {// 실행
				st = con.createStatement();
				rs = st.executeQuery(query);

				while (rs.next()) {
					ClassVO vo = new ClassVO();

					vo.setClassIdx(rs.getInt(1));
					vo.setCategoryIdx(rs.getInt(2));
					vo.setClassRegionIdx(rs.getInt(3));
					vo.setName(rs.getString(4));
					vo.setDate(rs.getString(5));
					vo.setPlace(rs.getString(7));
					vo.setPrice(rs.getInt(8));
					vo.setImage(rs.getString(14));

					list.add(vo);
				}
			} catch (Exception e) {
				System.out.println(e + "=> getEndlist fail");
			}

			return list;
		}// getCategorylist
		
		public ArrayList<ClassVO> getCategorylist(int category_idx, String regionIdx) {
			ArrayList<ClassVO> list = new ArrayList<ClassVO>();
			String query = "";
			if(regionIdx.equals("-1"))
				query = "SELECT * FROM class WHERE category_idx = " + category_idx+" AND is_closed = 0";
			else
				query = "SELECT * FROM class WHERE category_idx = " + category_idx + " AND class_region_idx= " + regionIdx+" AND is_closed = 0";

			try {// 실행
				st = con.createStatement();
				rs = st.executeQuery(query);

				while (rs.next()) {
					ClassVO vo = new ClassVO();

					vo.setClassIdx(rs.getInt(1));
					vo.setCategoryIdx(rs.getInt(2));
					vo.setClassRegionIdx(rs.getInt(3));
					vo.setName(rs.getString(4));
					vo.setDate(rs.getString(5));
					vo.setPlace(rs.getString(7));
					vo.setPrice(rs.getInt(8));
					vo.setImage(rs.getString(14));

					list.add(vo);
				}
			} catch (Exception e) {
				System.out.println(e + "=> getEndlist fail");
			}
			return list;
		}// getCategorylist

	// 카테고리명 검색
	public static String getCategoryByIdx(Connection con, int categoryIdx) {

		String query = "SELECT name FROM category WHERE category_idx=" + categoryIdx +" AND is_closed = 0";

		try {
			Statement st = con.createStatement();
			if (st.execute(query)) {
				ResultSet rs = st.getResultSet();

				while (rs.next()) {
					return rs.getString("name");
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 지역명 검색
	public static String getRegionByIdx(Connection con, int regionIdx) {

		String query = "SELECT name FROM class_region WHERE class_region_idx=" + regionIdx +" AND is_closed = 0";

		try {
			Statement st = con.createStatement();
			if (st.execute(query)) {
				ResultSet rs = st.getResultSet();

				while (rs.next()) {
					return rs.getString("name");
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// 이미 신청한 클래스인지 확인
	public static boolean duplicateApplicationClass(Connection con, int classIdx, int userIdx) {
		String query = String.format("SELECT * FROM application WHERE user_idx=%d AND class_idx=%d", userIdx, classIdx);
		
		try {
			Statement st = con.createStatement();
			if (st.execute(query)) {
				ResultSet rs = st.getResultSet();
				if (rs.next()) {
					return false;
				}else {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 클래스 신청하기 + apply_people 올리기
	public static int postApplicationClass(Connection con, int classIdx, int userIdx) {

		String query = "INSERT INTO application(user_idx, class_idx) VALUES (?,?)";
		String query2 = String.format("UPDATE class SET apply_people="
				+ "(SELECT apply_people FROM (SELECT * FROM class WHERE class_idx= %d)ntd)+1 WHERE class_idx = %d",
				classIdx, classIdx);
		String query3 = String.format("UPDATE class SET is_closed=1 "
				+ "WHERE apply_people = (select people from (SELECT * FROM class where class_idx = %d) query1) and class_idx=%d", classIdx, classIdx);
		
		try {

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, userIdx);
			ps.setInt(2, classIdx);

			int i = ps.executeUpdate();

			if (i == 1) {
				Statement st = con.createStatement();
				int result = st.executeUpdate(query2);

				if (result == 1) {
					Statement st1 = con.createStatement();
					st1.executeUpdate(query3);
					return i;
				}
			} else {
				return 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	// 클래스 신청 취소
	public static int deleteApplicationClass(Connection con, int classIdx, int userIdx) {
		String query = "DELETE FROM application WHERE class_idx = ? AND user_idx=?";
		String query2 = String.format("UPDATE class SET apply_people="
				+ "(SELECT apply_people FROM (SELECT * FROM class WHERE class_idx= %d)ntd)-1 WHERE class_idx = %d",
				classIdx, classIdx);
		String query3 = String.format("UPDATE class SET is_closed=0 "
				+ "WHERE apply_people < (select people from (SELECT * FROM class where class_idx = %d) query1) and class_idx=%d", classIdx, classIdx);
		
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, classIdx);
			ps.setInt(2, userIdx);
			int i = ps.executeUpdate();
			
			if (i == 1) { // 업데이트 성공
				Statement st = con.createStatement();
				int result = st.executeUpdate(query2);

				if (result == 1) {
					Statement st1 = con.createStatement();
					st1.executeUpdate(query3);
					return i;
				}
			} else {
				System.out.println(i + " " + "deleteClass 실패");
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 검색 클래스
	public ArrayList<ClassVO> getSearchlist(String keyWord) {
		ArrayList<ClassVO> list = new ArrayList<ClassVO>();

		String query = "SELECT * FROM class";
		if (keyWord != null && !keyWord.equals("")) {
			query += " WHERE name LIKE '%" + keyWord.trim() + "%' ";
		} else {// 모든 레코드 검색
			query += " order by class_idx";
		}

		try {// 실행
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				ClassVO vo = new ClassVO();

				vo.setClassIdx(rs.getInt(1));
				vo.setCategoryIdx(rs.getInt(2));
				vo.setClassRegionIdx(rs.getInt(3));
				vo.setName(rs.getString(4));
				vo.setDate(rs.getString(5));
				vo.setPlace(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setImage(rs.getString(14));

				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e + "=> getSearchlist fail");
		}
		return list;
	}// getSearchlist

	// 클래스 좋아요 post
	public static int postClassLike(Connection con, int classIdx, int userIdx) {
		String query = "INSERT INTO `like`(user_idx, class_idx) VALUES(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, userIdx);
			ps.setInt(2, classIdx);

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

	// 클래스 좋아요 get
	public static ResultSet getClassLike(Connection con, int classIdx, int userIdx) {
		String query = String.format("SELECT like_idx FROM `like` WHERE class_idx=" + classIdx + " AND user_idx=\"%s\"",
				userIdx);
		System.out.println(query);
		try {// 실행
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				return rs;
			}
		} catch (Exception e) {
			System.out.println(e + "=> getClassLike fail");
		}
		return null;
	}

	// 클래스 좋아요 delete
	public static int deleteClassLike(Connection con, int classIdx, int userIdx) {
		String query = String.format("DELETE FROM `like` WHERE class_idx=" + classIdx + " AND user_idx=\"%s\"", userIdx);
		System.out.println(query);
		try {// 실행
			Statement st = con.createStatement();
			int i = st.executeUpdate(query);
			return i;
		} catch (Exception e) {
			System.out.println(e + "=> deleteClassLike fail");
		}
		return 0;
	}
}
