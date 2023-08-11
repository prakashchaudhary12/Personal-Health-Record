package project.petreg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.patloginpage;

/**
 * Servlet implementation class doclogin
 */
@WebServlet("/doclogin")
public class doclogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doclogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String email_id = request. getParameter("email");
		String password = request. getParameter("pass");
		HttpSession session =request.getSession();
		RequestDispatcher dispatcher =null;
		
		
			
		
			if(patloginpage.validate(email_id,password)) {
				
				RequestDispatcher rd =request.getRequestDispatcher("patsuccess");
				rd.include(request, response);
			}else {
				out.print("Sorry email or password error");
				RequestDispatcher rd= request.getRequestDispatcher("patlogin.html");
			}
			dispatcher.forward(request, response);
	}

}
