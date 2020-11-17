package model;

import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DBconnection
 *
 */
@WebListener
public class DBconnection implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public DBconnection() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// connection을 가져옴
		Connection conn = (Connection) sce.getServletContext().getAttribute("DBconnection");
		
		// connection을 닫음
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		Connection conn = null;
		Properties connectionProps = new Properties();
		
		// servlet context 가져오기
		ServletContext sc = sce.getServletContext();
		String DBUrl = sc.getInitParameter("JDBCUrl");
		String DBuser = sc.getInitParameter("DBuser");
		String DBpasswd = sc.getInitParameter("DBpasswd");
		String DBTimeZone = sc.getInitParameter("DBTimeZone");

		connectionProps.put("user", DBuser);
		connectionProps.put("password", DBpasswd);
		connectionProps.put("serverTimezone", DBTimeZone);
		
		// connection 가져오기
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DBUrl, connectionProps);

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// connection에 성공하면 connection 값을 만듬
		sc.setAttribute("DBconnection", conn);
	}

}
