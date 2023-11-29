package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class DbValidationtest {

	public static void main(String[] args) throws SQLException {
		//Random number
		Random ran=new Random();
		
		//Dynamic input
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Employee name");
		String Name=sc.nextLine();
		
		
		//register database
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//get database connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet2", "root", "root");
		
		//create statement
		Statement state = con.createStatement();
        String query="select Name from employee where Name='"+Name+"';";
        
        
        //execute query
        ResultSet result = state.executeQuery(query);
        
        if(result.next())
        {
        	System.out.println("Data you have entered is already present please enter the new emplyoee name");
        	//System.out.println("Enter the Employee name");
        	String Name1=sc.nextLine();
        	int randomnum = ran.nextInt(100);
        	
        	//insert the data
        	String query1="insert into employee values('"+Name1+"',+'"+randomnum+"');";
        	//execute update query
        	int result2 = state.executeUpdate(query1);
        	
        	if(Name1.contains(Name1))
        	{
        		System.out.println("Data inserted successfully");
        	}
        	else
        	{
        		System.out.println("Data is not inserted");
        	}
      
        }
        else
        {
        	System.out.println("Data is not present");
        	System.out.println("Enter the Different Employee Name");
        	String Name1=sc.nextLine();
        	int randomnum = ran.nextInt(100);
        	
        	//insert the data
        	String query1="insert into employee values('"+Name1+"',+'"+randomnum+"');";
        	//execute update query
        	int result2 = state.executeUpdate(query1);
        	
        	if(Name1.contains(Name1))
        	{
        		System.out.println("Data inserted successfully");
        	}
        	else
        	{
        		System.out.println("Data is not inserted");
        	}
       	
        	
        }
        String query2 = "select * from employee;";
		
		//execute query
		ResultSet result2 = state.executeQuery(query2);
		while(result2.next())
		{
			System.out.println(result2.getString(1)+" "+result2.getInt(2));
		}
		
        //close database
		con.close();
		

	}

}
