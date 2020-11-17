package user;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBUtil;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		String passwd = request.getParameter("passwd");

		ServletContext sc = getServletContext();
		Connection conn = (Connection) sc.getAttribute("DBconnection");

		ResultSet rs = DBUtil.login(conn, mid);

		PrintWriter out = response.getWriter();

		if (rs != null) {
			try {
				if (rs.next()) { // existing user
					String checkpw = rs.getString(1);
					if (checkpw.equals(passwd)) { // valid user and password
						out.println("Login Success!!");
					} else { // wrong password
						System.out.println("Wrong Passwd!!");
						out.println("<script>alert('비밀번호가 틀렸습니다.'); history.back(); </script>");
					}
				} else { // invalid user
					out.println("<script>alert('존재하지 않는 사용자입니다.'); history.back(); </script>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
