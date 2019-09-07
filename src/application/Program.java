package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter client data: ");
		
		System.out.println("Name: ");
		String nameClient = sc.nextLine();
		
		System.out.println("Email: ");
		String emailClient = sc.nextLine();
		
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date data = sdf.parse(sc.nextLine());
		
		Client client = new Client(nameClient, emailClient, data);
		System.out.println(" \n");
		
		System.out.println("Enter order data:");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this order?");
		int x = sc.nextInt();
		
		for(int i=1;i<=x; i++) {
			
			
			System.out.println("Enter #" + i + " item data: \n");
			
			System.out.println("Product name: ");	
			sc.nextLine();
			String productName = sc.nextLine();
			
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice,product);
			
			order.addItem(orderItem);
		}
		
		
		System.out.println();

		System.out.println("ORDER SUMMARY:");

		System.out.println(order);

		

		sc.close();
	}

}
