import java.sql.SQLException;
import java.util.Scanner;

public class productDAO {
	static Scanner sc = new Scanner(System.in);
	static CRUD crud = new CRUD();
	
	public void insert() throws SQLException {
		product pro = new product();
		System.out.print("Enter the Name to be inserted : ");
		pro.setName(sc.nextLine());
		System.out.print("Enter the price to be inserted : ");
		pro.setPrice(sc.nextDouble());
		System.out.print("Enter the quantity to be inserted : ");
		pro.setQuantity(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter the description to be inserted : ");
		pro.setDescription(sc.nextLine());
		crud.addProduct(pro);

	}
	
	public void update() throws SQLException {
		System.out.println("Enter id that you want to update = ");
		int n = sc.nextInt();
			if(crud.checkID(n)) {
				crud.update(n);
			}else {
				System.out.println("There is no record with the id "+n);
			}
	}
	
	public void remove() throws SQLException {
		System.out.println("Enter id that you want to Delete");
		int n = sc.nextInt();
		if(crud.checkID(n)) {
			crud.delete(n);
		}else {
			System.out.println("There is no record with the id "+n);
		}
	}

	public void find() throws SQLException {
		System.out.println("Enter id that you want to search = ");
		int n = sc.nextInt();
			if(crud.checkID(n)) {
				crud.search(n);
			}else {
				System.out.println("There is no record with the id "+n);
			}
		}
	
	public void buy() throws SQLException {
		System.out.println("Enter id that you want to buy = ");
		int n = sc.nextInt();
			if(crud.checkID(n)) {
				crud.buyProduct(n);
			}else {
				System.out.println("There is no record with the id "+n);
			}
	}
}
