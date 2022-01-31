import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		CreateDB dbt = new CreateDB();
		User user = new User();
		UserDAO userDao = new UserDAO();
		AdminDAO adminDao = new AdminDAO();
		cartDAO cart = new cartDAO();
		
		if(dbt.createDatabase()) {
			dbt.createTable();
		}
		
		System.out.println("===================Welcome To Online Shopping=================");
		System.out.println("Please select an option to login");
		System.out.println("\n1. New User \n2. Existing User \n3. Admin");
		int n = sc.nextInt();
		int uid = 0;
		boolean validate = false;
		
		do {
			sc.nextLine();
			switch(n) {
			case 1:
				System.out.println("Enter your name : ");
				user.setName(sc.nextLine());
				System.out.println("Enter Email : ");
				user.setEmail(sc.nextLine());
				System.out.println("Enter Password : ");
				user.setPass(sc.nextLine());
				userDao.insertUser(user);
				System.out.println("Enter no.2 to login : ");
				n = sc.nextInt();
				break;
			case 2:
				System.out.println("User Login Page");
				System.out.println("Enter your Email : ");
				user.setEmail(sc.nextLine());
				System.out.println("Enter your Password : ");
				user.setPass(sc.nextLine());

				//validate user 
				if(userDao.validateUser(user.getEmail(),user.getPass())){
					System.out.println("User Login Successful");
					uid = userDao.getID(user.getEmail());
					validate = true;
				}else {
					System.out.println("Please enter valid login details");
					System.out.println("Enter no.2 to login : ");
					n = sc.nextInt();
				}
				break;
			case 3:
				System.out.println("Admin Login Page");
				System.out.println("Enter your Email : ");
				String email = sc.nextLine();
				System.out.println("Enter your Password : ");
				String Pass = sc.nextLine();

				//validate user 
				if(adminDao.validateAdmin(email,Pass)){
					System.out.println("Admin Login Successful");
					validate = true;
				}else {
					System.out.println("Please enter valid login details");
					System.out.println("Enter no.3 to login : ");
					n = sc.nextInt();
				}
				break;
			default:
				System.out.println("Please enter valid details");
				
			}
		}while(validate != true);
		
		cart.setID(uid);
		
		if(n==2) {
			userDao.userCRUD();
		}else if(n==3) {
			adminDao.adminCRUD();
		}
		System.out.println("=========================Thanks for shopping=======================");
	}

}
