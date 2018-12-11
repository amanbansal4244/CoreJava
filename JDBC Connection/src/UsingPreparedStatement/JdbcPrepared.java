package UsingPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcPrepared {
	public JdbcPrepared() throws Exception {
		//load the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Class is subcalss of Object class and forName is static method
		//@ip address : port: service(DB Name)
			String connectUrl="@localhost:1521:orcl";
		//build connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:"+connectUrl,"scott","tiger"); //need to know our user name and password
		
		
		
		
		//Instead of statement we have prepared statement which is allowed to set vales at run time
		
			PreparedStatement pst=con.prepareStatement("select * from emp where empno=?");
		
			pst.setInt(1,33);
		
			//pst.execute();  // Also write
	
		ResultSet rs=pst.executeQuery();
		//System.out.println(rs.getString(1));  will give an error
		while(rs.next()){
			System.out.println(rs.getString("ename")+" :" +rs.getString("job"));
			//System.out.println(rs.getInt("empno"));
		}
		
		con.close();  // For close the connection (Always good to close connection after work
		
		
	}
	public static void main(String[] args) throws Exception {
		JdbcPrepared obj=new JdbcPrepared();
	}
}
