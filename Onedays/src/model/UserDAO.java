package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

import javax.swing.JOptionPane;

public class UserDAO {
	
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
	
	public static int join(Connection con, String id, String password, String email, String name, String phone_number, int region) {

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
	
	public static int updateUserInfo(Connection con, String id, String password, String name, String phone, String email, int region, int user_idx) {
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
	
//	public static void saveImage(Connection con, File file) {
//		try { 
//			String img_id=JOptionPane.showInputDialog("Enter Image ID"); 
//			FileInputStream fis=null; 
//			String query="insert into class_img(class_img_idx,class_idx, img) values (?,?.?)"; 
//			PreparedStatement pstm=con.prepareStatement(query); 
//			fis=new FileInputStream(file); 
//			pstm.setString(1, img_id);  
//			pstm.setBinaryStream(2, (InputStream)fis, (int)file.length()); 
//			pstm.executeUpdate(); 
//			JOptionPane.showMessageDialog(null, "Image Successfully Uploaded to Database"); 
//			pstm.close(); 
//			con.close(); 
//
//		} catch (Exception ex) { 
//			System.out.println("Exception Occured: "+ex); 
//		} 
//	} 
//	
//	public static void getSavedImages(Connection con){ 
//		try { 
//			PreparedStatement pstm1 = con.prepareStatement("select * from class_img"); 
//			ResultSet rs1 = pstm1.executeQuery(); 
//			while(rs1.next()) { 
//				InputStream fis1; 
//				FileOutputStream fos; 
//				String image_id; 
//				try { 
//					fis1 = rs1.getBinaryStream("img"); 
//					image_id=rs1.getString("class_img_idx"); 
//					fos = new FileOutputStream(new File("path/to" + "C:\\" + (image_id) + "Your Extension(.jpg/.gif)")); 
//					int c; 
//					while ((c = fis1.read()) != -1) { 
//						fos.write(c); 
//					} 
//					fis1.close(); 
//					fos.close(); 
//
//				} catch (Exception ex) { 
//					System.out.println(ex); 
//				} 
//			} 
//			pstm1.close(); 
//			con.close(); 
//		} catch (Exception ex) { 
//			System.out.println("Exception Occured:"+ex); 
//		} 
//	} 
}