package employee.management.system;

import java.sql.*;

public class DBCon {

	Connection c;
	Statement s;
	public DBCon() {
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String url = "jdbc:sqlserver://DESKTOP-2EG2LKL;databaseName=EmsBase;user=javauser;"
			+ "password=Java@123;"
			+ "encrypt=true;trustServerCertificate=true";
			c = DriverManager.getConnection(url);
			s = c.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
