import java.sql.*;
import java.util.*;

public class CRUD extends MySQLConnection{
	    static Scanner sc = new Scanner(System.in);
	    static HashMap<Integer,String> map = new HashMap<>();
	    
		public void display() {
			try{
				Connection conn = connection();
				Statement stmt = conn.createStatement();
				System.out.println("The list of Products in the database are....\n");
				ResultSet rs=stmt.executeQuery("select * from products");
				  System.out.println("Id \t Name \t Price \t Qty \t Description");
				  while(rs.next()){
					  System.out.println(rs.getInt(1)+ "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getInt(4) + "\t" + rs.getString(5));  
				  }	
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		public boolean checkID(int n) throws SQLException {
			Connection conn = connection();
			try {
				  Statement stmt = conn.createStatement();
				  ResultSet rs=stmt.executeQuery("select pid from products");
				  
				  while(rs.next()) {
					  if(n == rs.getInt(1)) {
						  return true;
					  }
				  }
				  
				  return false;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return false;
			
		}
		
		public void addProduct(product pro) throws SQLException {
			Connection conn = connection();
			try{		
				  String query = "INSERT INTO products(pname,pprice,pquantity,pdescription) VALUES(?,?,?,?)";
				  PreparedStatement pstmt = conn.prepareStatement(query);
				  pstmt.setString(1, pro.getName());
				  pstmt.setDouble(2, pro.getPrice());
				  pstmt.setInt(3, pro.getQuantity());
				  pstmt.setString(4, pro.getDescription());
				  pstmt.executeUpdate();
				  System.out.println("Record inserted successfully");			  
				  
			}catch(Exception e) {
				conn.close();
			}
		}
		
		public void update(int n) throws SQLException {
			Connection conn = connection();
			try {
				  String query1 = "update products set pname = ? where pid = ?";
				  PreparedStatement pstmt1 = conn.prepareStatement(query1);
				  
				  String query2 = "update products set pprice = ? where pid = ?";
				  PreparedStatement pstmt2 = conn.prepareStatement(query2);
				  
				  String query3 = "update products set pquantity = ? where pid = ?";
				  PreparedStatement pstmt3 = conn.prepareStatement(query3);
				  
				  String query4 = "update products set pdescription = ? where pid = ?";
				  PreparedStatement pstmt4 = conn.prepareStatement(query4);
				  
				  System.out.println("please select the column that you want to update");
				  System.out.println("1. Name \n2. Price \n3. Quantity \n4. Description");
				  int num = sc.nextInt();
				  sc.nextLine();
				  switch(num) {
				  case 1:
					  System.out.println("Enter new name : ");
					  pstmt1.setString(1, sc.nextLine());
					  pstmt1.setInt(2, n);
					  pstmt1.executeUpdate();
					  break;
				  case 2:
					  System.out.println("Enter new price : ");
					  pstmt2.setDouble(1,sc.nextDouble());
					  pstmt2.setInt(2, n);
					  pstmt2.executeUpdate();
					  break;
				  case 3:
					  System.out.println("Enter new quantity : ");
					  pstmt3.setInt(1, sc.nextInt());
					  pstmt3.setInt(2, n);
					  pstmt3.executeUpdate();
					  break;
				  case 4:
					  System.out.println("Enter new description : ");
					  pstmt4.setString(1, sc.nextLine());
					  pstmt4.setInt(2, n);
					  pstmt4.executeUpdate();
					  break;
					  
				  default:
					  System.out.println("Enter valid number");
				  }
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void delete(int n) throws SQLException {
			Connection conn = connection();
			try {
				String query = "delete from products where pid = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, n);
				pstmt.executeUpdate();
				System.out.println("\nRecord deleted successfully...");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void search(int n) throws SQLException {
			Connection conn = connection();
			try {
				Statement stmt =conn.createStatement();
			    ResultSet rs=stmt.executeQuery("select * from products where pid =" + n);
			  while(rs.next()){
				  if(rs.getInt(1) == n) {
					  System.out.println(rs.getString(2)+ " " + rs.getDouble(3));
				  }  	  
			  }
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void buyProduct(int n) throws SQLException {
			Connection conn = connection();
			try {
				Statement stmt =conn.createStatement();
			    ResultSet rs=stmt.executeQuery("select pid,pquantity from products");
			    int qty = 0;
			  while(rs.next())
			  {
				  if(rs.getInt(1) == n) {
					  qty = rs.getInt(2);
				  }	  
			  }
				
			  if(qty > 1) {
				  String query3 = "update products set pquantity = ? where pid = ?";
				  PreparedStatement pstmt3 = conn.prepareStatement(query3);
				  pstmt3.setInt(1, qty - 1);
				  pstmt3.setInt(2, n);
				  pstmt3.executeUpdate();
			  }else {
				    String query = "delete from products where pid = ?";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, n);
					pstmt.executeUpdate();
			  }
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		/*public void addToCart() throws SQLException {
			Connection conn = connection();
			try {
				Statement stmt =conn.createStatement();
			    ResultSet rs=stmt.executeQuery("select id,name from products");
			    System.out.println("Enter the product id to add to cart : ");
			    int n = sc.nextInt();
			    while(rs.next()) {
			    	if(rs.getInt(1) == n) {
			    		map.put(n, rs.getString(2));
			    		System.out.println("Item added to cart successfully");
					  }
			    }
			    int num = 0;
			    do {
			    	System.out.println("\n1. View Cart \n2. Buy all items in cart \n3. Exit");
			    	num = sc.nextInt();
			    	switch(num) {
			    		case 1:
			    			System.out.println("The items in the cart are\n"+map);
			    			break;
			    		case 2:
			    			for(Map.Entry<Integer,String> entry : map.entrySet()) {
			    				buyProduct((int) entry.getKey());
			    			}
			    			map.clear();
			    			System.out.println("The items in the cart are\n" + map);
			    			break;
			    		case 3:
			    			break;
			    		default:
			    			System.out.println("Please enter a valid number");
			    			break;
			    	}
			    }while(num != 3); 
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	*/
}
