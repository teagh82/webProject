package com.session.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResponseChooseCansize
 */
@WebServlet("/SelectState.do")
public class ResponseChooseState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseChooseState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String s = request.getParameter("state");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("state", s);
		PrintWriter out = response.getWriter();
		
		out.println("<h1 align=1center1>Onedays Page 2</h1>");
		out.println("<form method='POST' action='Onedays.do'>");
		out.println("Select beer body!");
		out.println("test session attributes<br>");
		out.println("<p>");
		out.println("BODY: <select name='body' size='1'>");
		out.println("<option value='요리'>cook</option>");
		out.println("<option value='공예'>art</option>");
		out.println("<option value='운동'>exercise</option>");
		out.println("</select>");
		out.println("<br>");
		out.println("<br> <input type='SUBMIT'>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
