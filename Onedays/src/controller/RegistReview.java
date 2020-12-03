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

import model.ReviewVO;
import model.ReviewDAO;

/**
 * Servlet implementation class RegistReview
 */
@WebServlet("/RegistReview")
public class RegistReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistReview() {
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
		if(session.isNew() || session==null) {
			out.println("<script>alert('로그인 후 이용해주세요.'); location.replace(\"login.jsp\"); </script>");
		}		
		
		ReviewVO review = new ReviewVO();
		review.setClassIdx(Integer.parseInt(request.getParameter("classIdx")));
		review.setUserIdx(Integer.parseInt(session.getAttribute("user_idx").toString()));
		review.setContent(request.getParameter("content"));
		review.setUserName(session.getAttribute("mid").toString());

		int result = ReviewDAO.postReview(con, review);
		if (result == 1) {
			System.out.println("regist review success");
	        out.println ("<script>");
	        out.println ("window.close(); opener.location.reload(true);");
	        out.println ("</script>");
		} else
			System.out.println("regist review fail");
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
