import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	public static Connection connection() throws SQLException {
    	return DriverManager.getConnection("jdbc:mysql://localhost:3306/EcomDB","root","root");
    }
    
}
