package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Nonselectquery {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		int result=0;
		try {
		//Register the database
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		
		//get connection for database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet2", "root", "root");
		
		
		//create statement
		Statement state = con.createStatement();
		String query = "update employee_info SET Address='Kolkata' where EmpName='Salma';";
		//String query = "delete from employee_info where EmpName='Ruman';";
		
		
		//ExcecuteUpdate query
		 result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data updated successfully");
		}
		else
		{
			System.err.println("Not updated");
		}
		}
		catch(Exception e)
		{
		}
		finally {
			//close database
			con.close();

			
		}
		
		
		
		
	}

}
