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
 * Servlet implementation class ApplicationClass
 */
@WebServlet("/ApplicationClass")
public class ApplicationClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplicationClass() {
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

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		if (session.isNew() || session == null) {
			out.println("<script>alert('로그인 후 이용해주세요.'); location.replace(\"login.jsp\"); </script>");
		}

		ServletContext sc = getServletContext();
		Connection con = (Connection) sc.getAttribute("DBconnection");

		int classIdx = Integer.parseInt(request.getParameter("classIdx"));
		int userIdx = Integer.parseInt(session.getAttribute("user_idx").toString());
		
		boolean flag = ClassDAO.duplicateApplicationClass(con, classIdx, userIdx);
		if (flag) {
			int result = ClassDAO.postApplicationClass(con, classIdx, userIdx);
			if (result == 1) {
				session.setAttribute("apply_check","ok");
				out.println(
						"<script>alert('클래스 신청이 완료되었습니다.'); location.replace(\"apply.jsp\"); </script>\" </script>");
			} else {
				out.println("<script>alert('클래스 신청에 실패했습니다.'); history.back(); </script>\" </script>");
			}
		} else {
			out.println("<script>alert('이미 신청한 클래스입니다.'); history.back(); </script>\" </script>");
		}

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
