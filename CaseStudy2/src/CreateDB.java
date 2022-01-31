import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
	public boolean createDatabase() {
		try {
		      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		      String mysqlUrl = "jdbc:mysql://localhost/";
		      Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
		      System.out.println("Connection established......");
		      Statement stmt = con.createStatement();
		      String query = "CREATE database EcomDB";
		      stmt.execute(query);
		      System.out.println("Database created");
		      return true;
		  }catch(Exception e) {
			  System.out.println("Database already exists");
			  return true;
		  }
	}
	
	public void createTable() throws SQLException {
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EcomDB","root","root");
				Statement stmt = conn.createStatement();
				){
			String sql1 = "Create table products " + 
						"(pid INTEGER not NULL AUTO_INCREMENT, " + 
						"pname VARCHAR(50), " +
						"pprice DOUBLE(10,2), " +
						"pquantity INTEGER, " +
						"pdescription VARCHAR(50), " +
						"PRIMARY KEY (pid))";
			
			String sql2 = "Create table admin "+
						  "(aid INTEGER NOT NULL AUTO_INCREMENT, "+
						  "aname VARCHAR(50), " +
						  "aemail VARCHAR(50), " +
						  "apass VARCHAR(50), " +
						  "PRIMARY KEY (aid))";
			
			String sql3 = "Create table user "+
					  "(uid INTEGER NOT NULL AUTO_INCREMENT, "+
					  "uname VARCHAR(50), " +
					  "uemail VARCHAR(50), " +
					  "upass VARCHAR(50), " +
					  "PRIMARY KEY (uid))";
			
			String sql4 = "Create table cart "+
					  "(cid INTEGER NOT NULL AUTO_INCREMENT, "+
					  "p_name VARCHAR(50), " +
					  "p_price DOUBLE(10,2), " +
					  "user_id INTEGER, " +
					  "PRIMARY KEY (cid))";
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			System.out.println("Tables Created successfully");
		}catch(Exception e) {
			System.out.println("Tables already exist");
			
		}
	}
}
