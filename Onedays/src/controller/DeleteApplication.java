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
import model.UserDAO;

/**
 * Servlet implementation class DeleteApplication
 */
@WebServlet("/DeleteApplication")
public class DeleteApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteApplication() {
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

		int user_idx = Integer.parseInt(session.getAttribute("user_idx").toString());
		int class_idx = Integer.parseInt(request.getParameter("class_idx"));

		ServletContext sc = getServletContext();
		Connection conn = (Connection) sc.getAttribute("DBconnection");

		int result = ClassDAO.deleteApplicationClass(conn, class_idx, user_idx);

		if (result == 1) {
			out.println("<script>alert('클래스 신청이 취소되었습니다.'); location.replace(\"apply.jsp\"); </script>\" </script>");
		} else {
			out.println("<script>alert('클래스 신청 취소에 실패했습니다.'); history.back(); </script>");
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
