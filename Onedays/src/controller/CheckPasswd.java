package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;

/**
 * Servlet implementation class CheckPasswd
 */
@WebServlet("/CheckPasswd")
public class CheckPasswd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPasswd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		//로그인 여부 체크
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("mid");
		if (id == null) {
			response.sendRedirect("login.jsp");
		}

		String passwd = request.getParameter("passwd");

		ServletContext sc = getServletContext();
		Connection conn = (Connection) sc.getAttribute("DBconnection");
		
		ResultSet rs = UserDAO.login(conn, id);
		
		PrintWriter out = response.getWriter();

		if (rs != null) {
			
			try {
				if (rs.next()) { // existing user
					String checkpw = rs.getString("password");
					if (checkpw.equals(passwd)) { // valid user and password						
						response.sendRedirect("myPage.jsp");
						
					} else { // wrong password
						out.println("<script>alert('비밀번호가 틀렸습니다.'); history.back(); </script>");
					}
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
