/*
 * main method to utilize Customer and Customer Roster
 * @author - Madeleine Saucier
 */
package assg9_saucierm20;

import java.util.*;

public class CustomerMIS {
	
	public static void main(String[] args) {
		int opt; //for switch statement
		Scanner kbd = new Scanner(System.in);
		CustomerRoster roster = new CustomerRoster();
		String key, name, phone; //for getting customer info from kbd
		String filename = "assg9_CustomerRoster.txt";
		
		do {
			menu();
			opt = kbd.nextInt();
			kbd.nextLine(); //clear kbd buffer
			
			switch(opt) {
			case 1:
				roster.display();
				break;
			case 2:
				System.out.println("Enter new customer id: ");
				key = kbd.nextLine();
				
				if(roster.search(key)) {
					System.out.println("Customer " + key + " already exists");
					break;
				}
				
				System.out.println("Enter new customer name: ");
				name = kbd.nextLine();
				
				
				System.out.println("Enter new customer phone number: ");
				phone = kbd.nextLine();
				
				roster.addCustomer(new Customer(name, key, phone));
				
				System.out.println("Customer " + key + " added");
				break;
			case 3:
				System.out.println("Enter id of customer to delete: ");
				key = kbd.nextLine();
				
				if(!roster.search(key)) {
					System.out.println("Customer " + key + " does not exist");
					break;
				}
				
				roster.deleteCustomer(key);
				System.out.println("Customer " + key + " deleted");
				break;
			case 4:
				System.out.println("Enter id of customer to search for: ");
				key = kbd.nextLine();
				
				if(roster.search(key)) {
					System.out.println("Customer name: " + roster.getCustomer(key).getName());
					System.out.println("Customer phone number: " + roster.getCustomer(key).getNum());
				}
				else {
					System.out.println("Customer " + key + " does not exist");
				}
				break;
			case 5:
				System.out.println("Enter id of customer to edit: ");
				key = kbd.nextLine();
				if(!roster.search(key)) {
					System.out.println("Customer " + key + " does not exist");
				}
				
				System.out.println("1. Edit name");
				System.out.println("2. Edit phone number");
				System.out.println("Enter option: ");
				
				opt = kbd.nextInt();
				kbd.nextLine(); //clear kbd buffer
				
				if(opt == 1) {
					System.out.println("Enter new name: ");
					name = kbd.nextLine();
					roster.getCustomer(key).setName(name);
				}
				else if(opt == 2) {
					System.out.println("Enter new phone number: ");
					phone = kbd.nextLine();
					roster.getCustomer(key).setNum(phone);
				}
				else {
					System.out.println("Invalid option.");
				}
				break;
			case 6:
				roster.loadData(filename);
				break;
			case 7:
				roster.saveData(filename);
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			System.out.println("");
		}while(opt != 7);
		
		kbd.close();
		
	}
	
	
	public static void menu() {
		System.out.println("1. Display roster");
		System.out.println("2. Add customer");
		System.out.println("3. Delete customer");
		System.out.println("4. Search by ID");
		System.out.println("5. Change customer information");
		System.out.println("6. Load data");
		System.out.println("7. Save and exit");
		System.out.println("Enter option: ");
		
	}
	

}
