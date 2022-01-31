import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserDAO extends MySQLConnection{
	static Scanner sc = new Scanner(System.in);
	static CRUD crud = new CRUD();
	static productDAO pro = new productDAO();
	static cartDAO cart = new cartDAO();
	
	public boolean validateUser(String email, String pass) throws SQLException {
		Connection conn = connection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select upass from user where uemail = '" +email+"'");
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
	
	public void insertUser(User user) throws SQLException {
		Connection conn = connection();
		try{		
			  String query = "INSERT INTO user(uname,uemail,upass) VALUES(?,?,?)";
			  PreparedStatement pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, user.getName());
			  pstmt.setString(2, user.getEmail());
			  pstmt.setString(3, user.getPass());
			  pstmt.executeUpdate();
			  System.out.println("User inserted successfully");			  
			  
		}catch(Exception e) {
			conn.close();
		}
	}
	
	public int getID(String email) throws SQLException {
		Connection conn = connection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select uid from user where uemail = '" +email+"'");
			int id = 0;
			while(rs.next()) {
				id = rs.getInt(1);
			}
			
			return id;
		}catch(Exception e) {
		
		}
		return 0;

	}
	
	public void userCRUD() throws SQLException {
		int n = 0;
		do {
			System.out.println("\nPlease select an option : ");
			System.out.println("1. View All Products \n2. Search a Product \n3. Cart \n4. Buy a product \n5. Exit");
			n = sc.nextInt();
			sc.nextLine();
			switch(n) {
			case 1:
				crud.display();
				break;
			case 2:
				pro.find();
				break;
			case 3:
				cart.cartCURD();
				break;
			case 4:
				pro.buy();
				break;
			case 5:
				break;
			default:
				System.out.println("Please enter a valid number");
			}
		}while(n != 5);
	}
}
