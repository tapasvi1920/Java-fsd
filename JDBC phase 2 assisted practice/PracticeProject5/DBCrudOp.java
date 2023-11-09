package PracticeProject5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCrudOp 
{
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
	Statement st=con.createStatement();
	//create a database
	st.execute("create database mphasis");
	//select a database
	st.execute("use mphasis");
	//drop a database
	st.execute("drop database mphasis");
	con.close();
	
}
}
