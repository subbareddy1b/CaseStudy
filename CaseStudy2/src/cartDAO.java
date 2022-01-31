import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class cartDAO extends MySQLConnection {
	static cart ct = new cart();
	static int id = 0;
	static CRUD crud = new CRUD();
	static Scanner sc = new Scanner(System.in);
	
	public void setID(int n) {
		id = n;
	}
	
	public void viewCart(){
		try{
			Connection conn = connection();
			Statement stmt = conn.createStatement();
			System.out.println("The list of items in the cart are....\n");
			ResultSet rs=stmt.executeQuery("select * from cart where user_id = "+id);
			  System.out.println("Id \t Name \t Price");
			  while(rs.next()){
				  System.out.println(rs.getInt(1)+ "\t" + rs.getString(2) + "\t" + rs.getDouble(3));  
			  }	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addtoCart() throws SQLException {
		Connection conn = connection();
		try{		
			  System.out.println("Enter Product ID that you want to add to cart : ");
			  int num = sc.nextInt();
			  String query = "INSERT INTO cart(p_name,p_price,user_id,p_id) VALUES(?,?,?,?)";
			  PreparedStatement pstmt = conn.prepareStatement(query);
			  
			  Statement stmt = conn.createStatement();
			  ResultSet rs=stmt.executeQuery("select * from products");
				  while(rs.next()){
					  if(rs.getInt(1) == num) {
						  pstmt.setString(1,rs.getString(2));
						  pstmt.setDouble(2, rs.getDouble(3));
						  pstmt.setInt(3, id);
						  pstmt.setInt(4, rs.getInt(1));
						  pstmt.executeUpdate();
					  }  
				  }	
			  System.out.println("Record inserted successfully");			  
			  
		}catch(Exception e) {
			conn.close();
		}
	}
	
	public void buyFromCart() throws SQLException {
		Connection conn = connection();
		try {
			System.out.println("Select ID to buy from cart : ");
			int n = sc.nextInt();
			Statement stmt =conn.createStatement();
		    ResultSet rs=stmt.executeQuery("select cid,p_id from cart");
			while (rs.next()) {
				if (rs.getInt(1) == n) {
					crud.buyProduct(rs.getInt(2));
					String query = "delete from cart where cid = ?";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, n);
					pstmt.executeUpdate();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void deleteFromCart() {
		
		try {
			Connection conn = connection();
			System.out.println("Select ID to remove from cart : ");
			int n = sc.nextInt();
			String query = "delete from cart where cid = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, n);
			pstmt.executeUpdate();
			System.out.println("\nRecord deleted successfully...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buyAllFromCart() {
		try {
			Connection conn = connection();
			Statement stmt =conn.createStatement();
		    ResultSet rs=stmt.executeQuery("select user_id,p_id from cart");
			while (rs.next()) {
				if (rs.getInt(1) == id) {
					crud.buyProduct(rs.getInt(2));
					String query = "delete from cart where user_id = ?";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, id);
					pstmt.executeUpdate();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cartCURD() throws SQLException {
		int n = 0;
		do {
			System.out.println("\nPlease select an option : ");
			System.out.println("1. View Products in cart \n2. Add a Product To cart \n3. Buy a Product from Cart " + 
			"\n4. Buy all products \n5. Delete from cart \n6. Exit");
			n = sc.nextInt();
			sc.nextLine();
			switch(n) {
			case 1:
				viewCart();
				break;
			case 2:
				addtoCart();
				break;
			case 3:
				buyFromCart();
				break;
			case 4:
				buyAllFromCart();
				break;
			case 5:
				deleteFromCart();
				break;
			case 6:
				break;
			default:
				System.out.println("Please enter a valid number");
			}
		}while(n != 6);
	}
}
