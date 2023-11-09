package PracticeProject3;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDemo 
{
public static void main(String[] args) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseone","root","root");
	Statement st=con.createStatement();
 	ResultSet rs=st.executeQuery("select * from emp");
 	while(rs.next())
	{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));//getter are present in resultset interface//getter method fetch the values based on the columnn number
	}
	con.close();
 	
	
}
}
