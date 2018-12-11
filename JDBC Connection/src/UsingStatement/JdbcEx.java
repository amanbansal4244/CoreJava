package UsingStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcEx {
	public JdbcEx() throws Exception {
		//load the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Class is subcalss of Object class and forName is static method
		//@ip address : port: service(DB Name)
			String connectUrl="@localhost:1521:orcl";
		//build connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:"+connectUrl,"scott","tiger"); //need to know our user name and password
		
			Statement stat=con.createStatement();
		
			
			ResultSet rs=stat.executeQuery("select * from emp");
			stat.execute("insert into EMP (empno,ename,job) values (10,'aman','tranie')");
			while(rs.next())
			{
				System.out.println(rs.getString("ename")+" :" +rs.getString("job"));
			}
		
		
		con.close();
		
		
	}
	public static void main(String[] args) throws Exception {
		JdbcEx obj=new JdbcEx();
	}
}
