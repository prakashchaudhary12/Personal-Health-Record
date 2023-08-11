package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;

public class docloginpage {
	public static boolean validate(String email_id, String password) {
		boolean status =false;
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSl=false","root","hrithik");
			PreparedStatement pst= con.prepareStatement("select* from patient where email_id = ? and password = ?");
			pst.setString(1, email_id);
			pst.setString(2, password);
			
			
			ResultSet rs =pst.executeQuery();
			status=rs.next();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
