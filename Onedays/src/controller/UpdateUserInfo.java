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

import model.UserDAO;

/**
 * Servlet implementation class UpdateUserInfo
 */
@WebServlet("/UpdateUserInfo")
public class UpdateUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		if(session.isNew() || session==null) {
			out.println("<script>alert('로그인 후 이용해주세요.'); location.replace(\"login.jsp\"); </script>");
		}

		String id = request.getParameter("mid");
		String password = request.getParameter("passwd");
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String region = request.getParameter("region");

		ServletContext sc = getServletContext();
		Connection conn = (Connection) sc.getAttribute("DBconnection");
		

		System.out.println(id + " " + password + " " + name + " " + email + " " + phone + " " + region);
		int result = UserDAO.updateUserInfo(conn, id, password, name, phone, email, Integer.parseInt(region),
				Integer.parseInt(session.getAttribute("user_idx").toString()));
		
		if (result == 1) {
//			response.sendRedirect("myPage.jsp");
//			response.setHeader("REFRESH", "0");
			out.println("<script>alert('회원정보 수정이 완료되었습니다.'); location.replace(\"myPage.jsp\"); </script>");
		} else {
			out.println("<script>alert('회원정보 수정에 실패했습니다.'); history.back(); </script>");
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
