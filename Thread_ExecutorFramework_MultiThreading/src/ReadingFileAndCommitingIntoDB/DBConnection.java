package ReadingFileAndCommitingIntoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnection {

	private static String dbUserName = "root";
	private static String dbPassword = "bansal";
	private static String dbServerName = "localhost";
	private static String dbName = "sys";

	private static Connection  dbConnection;

	public static void saveInfoInDB(Record r) throws SQLException {
		//System.out.println("*******************************************************************");

		if(dbConnection == null) {
			dbConnection = getDBConnection();
		}

		PreparedStatement stmt = dbConnection.prepareStatement("Insert into DBReadWriteProcessTable(COL1,COL2,COL3) values (?,?,?)");
		stmt.setString(1, r.getCol1());
		stmt.setString(2, r.getCol2());
		stmt.setString(3, r.getCol3());

		int i = stmt.executeUpdate();
		dbConnection.commit();
		//System.out.println(i+"Record Inserted");

	}

	private static Connection getDBConnection() {
		try {
			if(dbConnection == null) {
				dbConnection = createDBConnection(dbUserName, dbPassword, dbServerName, dbName);

				if(dbConnection == null) {
					System.out.println("Error while getting the connection. So Termating the process............");
				}

			}
		}catch(Exception e) {
			System.out.println("Error while getting the connection. So Termating the process............" + e.getMessage());
		}
		return dbConnection;
	}

	private static Connection createDBConnection(String dbUserName2, String dbPassword2, String dbServerName2, String dbName2) {
		if(dbUserName2 == null || dbPassword2 == null || dbServerName2 == null || dbName2== null ) {
			System.out.println("Connection String is not valid........");
			return null;
		}

		String _strURL = null;
		try {
			System.out.println("Here, while creating connection.....");
			Class.forName("com.mysql.jdbc.Driver");  
			_strURL = "jdbc:mysql://"+ dbServerName2+"/"+dbName2;
			dbConnection = DriverManager.getConnection(_strURL,dbUserName2, dbPassword2);
			if(dbConnection == null) {
				System.out.println("Error while creating the DB connection. So Termating the process............");
			}else {
				dbConnection.setAutoCommit(false);
			}

			return dbConnection;
		}catch(Exception e){
			System.out.println("Exception Occurred, while creating connection.....");
			e.printStackTrace();
			dbConnection = null;
		}
		return dbConnection;
	}
}
