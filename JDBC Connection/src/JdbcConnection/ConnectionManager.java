

// Always good to have different class for open and close connection 
// And call these below teo method to open and close the connection from any class method

package JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager {
	Connection con=null;
	
	Connection newConnection() throws Exception {
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectUrl="@localhost:1521:orcl";
		 con=DriverManager.getConnection("jdbc:oracle:thin:"+connectUrl,"scott","tiger");
		 
		
		return con;
	}
	}
	void closeConnection(Connection con) 
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

