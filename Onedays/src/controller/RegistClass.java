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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import model.ClassDAO;
import model.ClassVO;

/**
 * Servlet implementation class RegistClass
 */
@WebServlet("/RegistClass")
public class RegistClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int size = 1024 * 1024 * 10;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistClass() {
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

		String path = request.getSession().getServletContext().getRealPath("uploadImg");
		MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

		ClassVO inputClass = new ClassVO();
		inputClass.setCategoryIdx(Integer.parseInt(multi.getParameter("categoryIdx")));
		inputClass.setClassRegionIdx(Integer.parseInt(multi.getParameter("RegionIdx")));
		inputClass.setName(multi.getParameter("name"));
		inputClass.setDate(multi.getParameter("date"));
		inputClass.setTime(multi.getParameter("time"));
		inputClass.setPlace(multi.getParameter("place"));
		inputClass.setPrice(Integer.parseInt(multi.getParameter("price")));
		inputClass.setLevel(multi.getParameter("level"));
		inputClass.setPeople(Integer.parseInt(multi.getParameter("people")));
		inputClass.setContent(multi.getParameter("content"));
		inputClass.setTeacherInfo(multi.getParameter("teacherInfo"));
		inputClass.setImage(multi.getFilesystemName("image"));
		inputClass.setUserIdx(Integer.parseInt(session.getAttribute("user_idx").toString()));

//		System.out.println(inputClass.getImage() + " " + inputClass.getClassRegionIdx());

		int result = ClassDAO.postClass(con, inputClass);
		if (result == 1) {
			System.out.println("regist Class success");
			response.sendRedirect("makeClass.jsp");
		} else
			System.out.println("regist Class fail");
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
