package UsingPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcPreparedDynamicValues {
	public JdbcPreparedDynamicValues() throws Exception {
		//load the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Class is subcalss of Object class and forName is static method
		//@ip address : port: service(DB Name)
			String connectUrl="@localhost:1521:orcl";
		//build connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:"+connectUrl,"scott","tiger"); //need to know our user name and password
		
		
		
		
		//Instead of statement we have prepared statement which is allowed o set vales at run time
		PreparedStatement pst=con.prepareStatement("insert into EMP (empno,ename,job) values (?, ?,?)");
			
		// Sequence doesn matter but indexing matter and indexing cant be duplicate
		pst.setString(3, "st"); // 3 is indexing that means 3rd question marks that is job column
		pst.setInt(1,33);
		pst.setString(2, "dt");
		
		//pst.execute();   // Also write
	
		ResultSet rs=pst.executeQuery();
		//System.out.println(rs.getString(1));  will give an error
		while(rs.next()){
			System.out.println(rs.getString("ename")+" :" +rs.getString("job"));
			//System.out.println(rs.getInt("empno"));
		}
		con.close();
		
		
	}
	public static void main(String[] args) throws Exception {
		JdbcPreparedDynamicValues obj=new JdbcPreparedDynamicValues();
	}
}
