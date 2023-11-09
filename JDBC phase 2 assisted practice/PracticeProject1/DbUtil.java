package PracticeProject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil 
{
public static Connection dbConn() throws ClassNotFoundException, SQLException
{
	//Register the Driver
	Class.forName(DbConstantPool.DRIVER_CLASS);
	
	//Connection with DB
	Connection con=DriverManager.getConnection(DbConstantPool.DRIVER_URL,DbConstantPool.USERNAME,DbConstantPool.PASSWORD);
	return con;
	
	
}
}
