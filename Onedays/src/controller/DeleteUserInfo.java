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
 * Servlet implementation class DeleteUserInfo
 */
@WebServlet("/DeleteUserInfo")
public class DeleteUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		if(session.isNew() || session==null) {
			out.println("<script>alert('로그인 후 이용해주세요.'); location.replace(\"login.jsp\"); </script>");
		}

		int user_idx = (int) session.getAttribute("user_idx");

		ServletContext sc = getServletContext();
		Connection conn = (Connection) sc.getAttribute("DBconnection");
		
		int result = UserDAO.deleteUserInfo(conn, user_idx);
		
		if (result == 1) {
			out.println("<script>alert('회원정보 탈퇴가 완료되었습니다.'); location.replace(\"index.jsp\"); </script>");
			session.invalidate();
		} else {
			out.println("<script>alert('회원정보 탈퇴에 실패했습니다.'); history.back(); </script>");
		}

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
