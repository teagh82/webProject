package controller;

import java.io.*;
import java.sql.*;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;

/**
 * Servlet implementation class DoJoin
 */
@WebServlet(urlPatterns = { "/doJoin" })
public class DoJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoJoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("memid");
		String password = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int region = Integer.parseInt(request.getParameter("region"));

		ServletContext sc = getServletContext();
		Connection conn = (Connection) sc.getAttribute("DBconnection");
		PrintWriter out = response.getWriter();

		ResultSet rs = UserDAO.duplicateCheck(conn, id);
		System.out.println("doJoin = " + id + " " + email + " " + password + " " + name + " ");
		System.out.println("region = " + region);
		
		try {
			if (!rs.next()) { // 처음 가입하는 회원일 시 회원가입 실행
				int result = UserDAO.join(conn, id, password, email, name, phone, region);
				if (result == 1) {
					response.sendRedirect("JoinSuccess.jsp");
				} else {
					out.println("<script>alert('회원가입에 실패했습니다.'); history.back(); </script>");
				}
			} else {
				out.println("<script>alert('중복된 아이디입니다.'); history.back(); </script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
