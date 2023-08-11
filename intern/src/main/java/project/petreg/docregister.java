package project.petreg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class docregister
 */
@WebServlet("/docregister")
public class docregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
    
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String doctor_email_id = request.getParameter("email");
		String Doctor_Name = request.getParameter("name");
		String doctor_moblie_number = request.getParameter("mob");
		String Specialization= request.getParameter("spl");
		String Password = request.getParameter("pass");
		
		

	
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSl=false","root","hrithik");
			PreparedStatement pst= con.prepareStatement("insert into doctor(doc_email,doc_name,doc_moblie_no,Specialization,password)values(?,?,?,?,?)");
			pst.setString(1, doctor_email_id);
			pst.setString(2, Doctor_Name);
			pst.setString(3, doctor_moblie_number);
			pst.setString(4, Specialization);
			pst.setString(5, Password);
			
			int rowCount=pst.executeUpdate();
			
			if(rowCount>0) {
				out.print("you are successfully registered");
				 RequestDispatcher rd =request.getRequestDispatcher("registrationdoctor.html");
				 rd.include(request,response);
				 }
				 
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

	}

}
}
}