package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ClassDAO;

/**
 * Servlet implementation class RegistLike
 */
@WebServlet("/RegistLike")
public class RegistLike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistLike() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ServletContext sc = getServletContext();
		Connection con = (Connection) sc.getAttribute("DBconnection");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		if (session.isNew() || session == null) {
			out.println("<script>alert('로그인 후 이용해주세요.'); location.replace(\"login.jsp\"); </script>");
		}

		int flag = Integer.parseInt(request.getParameter("flag"));
		int classIdx = Integer.parseInt(request.getParameter("classIdx"));
		int result;

		if (flag == 0) {
			result = ClassDAO.postClassLike(con, classIdx,
					Integer.parseInt(session.getAttribute("user_idx").toString()));
		} else {
			result = ClassDAO.deleteClassLike(con, classIdx,
					Integer.parseInt(session.getAttribute("user_idx").toString()));
		}
		if (result == 1) {
			System.out.println("CRUD Like success");
			response.sendRedirect("detail.jsp?classIdx=" + classIdx);
		} else
			System.out.println("CRUD Like fail");
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
