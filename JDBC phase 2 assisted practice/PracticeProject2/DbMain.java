package PracticeProject2;

import java.sql.Connection;
import java.sql.SQLException;

public class DbMain 
{
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Connection con=DbUtil.dbConn();
	if(con!=null)
	{
		System.out.println("dB connection is established successfully....");

	}
	
}
}
