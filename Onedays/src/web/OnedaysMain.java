package web;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OnedaysExpert;

/**
 * Servlet implementation class OnedaysMain
 */
@WebServlet(description = "Onedays", urlPatterns = { "/Onedays.do" })
public class OnedaysMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnedaysMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		request.setCharacterEncoding("UTF-8");
		
		String b = request.getParameter("body");
		
		HttpSession session = request.getSession();
		
		String s = (String)session.getAttribute("state");
		
		OnedaysExpert be = new OnedaysExpert();
		List result = be.gatState(s);
		
		request.setAttribute("next", result);
		request.setAttribute("state", s);
		RequestDispatcher view = request.getRequestDispatcher("Onedays.jsp");
		view.forward(request, response);
		
		/*2.ver
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Beer Selection Advice<br>");
		Iterator it = result.iterator();
		while (it.hasNext()) {
			out.println("<br>try: " + it.next());
		}	
		*/
		
		/* 1.ver
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Beer Selection Advice<br>");
		String c = request.getParameter("color");
		out.println("<br>Gotbeer color " + c);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
