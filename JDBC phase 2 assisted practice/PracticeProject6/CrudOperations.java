package PracticeProject6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOperations 
{
public static void main(String[] args) throws ClassNotFoundException, SQLException
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseone","root","root");
Statement st=con.createStatement();
//insert
st.execute("insert into emp values(103,'akshay',23)");
st.execute("insert into emp values(201,'raghul',32)");
st.execute("insert into emp values(123,'Rashmi',27)");
//delete
st.execute("delete from emp where id='101'");
//update
st.execute("update emp set id=333 where id='103'");

con.close();
}
}
