import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminDAO extends MySQLConnection{
	static Scanner sc = new Scanner(System.in);
	static CRUD crud = new CRUD();
	static productDAO pro = new productDAO();
	
	public boolean validateAdmin(String email, String pass) throws SQLException {
		Connection conn = connection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select apass from admin where aemail = '" +email+"'");
			String paswd = "";
			while(rs.next()) {
				paswd = rs.getString(1);
			}
			
			if(pass.equals(paswd)) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("Invalid Email");
		}
		return false;
	}
	
	public void adminCRUD() throws SQLException{
		int n = 0;
		do {
			System.out.println("\nPlease select an option : ");
			System.out.println("1. View Products \n2. Add a product \n3. Update a product \n4. Delete a product \n5. Exit");
			n = sc.nextInt();
			sc.nextLine();
			switch(n) {
			case 1:
				crud.display();
				break;
			case 2:
				pro.insert();
				break;
			case 3:
				pro.update();
				break;
			case 4:
				pro.remove();
				break;
			case 5:
				break;
			default:
				System.out.println("Please enter a valid number");
			}
		}while(n != 5);
	}
		
}
