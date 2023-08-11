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
 * Servlet implementation class petregister
 */
@WebServlet("/petregister")
public class patregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String Patient_Name = request.getParameter("name");
		String Email_id = request.getParameter("email");
		String date_of_birth = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String moblie_number = request.getParameter("mob");
		String blood_group = request.getParameter("blood");
		String address = request.getParameter("add");
		String Password = request.getParameter("pass");
	
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSl=false","root","hrithik");
			PreparedStatement pst= con.prepareStatement("insert into patient(patient_name,email_id,data_of_birth,gender,moblie_number,blood_group,address,password)values(?,?,?,?,?,?,?,?)");
			pst.setString(1, Patient_Name);
			pst.setString(2, Email_id);
			pst.setString(3, date_of_birth);
			pst.setString(4, gender);
			pst.setString(5, moblie_number);
			pst.setString(6, blood_group);
			pst.setString(7, address);
			pst.setString(8, Password);
			int rowCount=pst.executeUpdate();
			
			if(rowCount>0) {
				out.print("you are successfully registered");
				 RequestDispatcher rd =request.getRequestDispatcher("registrationpatient.html");
				 rd.include(request,response);}
				 else
				 {
					 out.print("you are not successfully registered");
					 RequestDispatcher rd =request.getRequestDispatcher("registrationpatient.html");
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
