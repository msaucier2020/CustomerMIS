/*
 * a class for a customer roster
 * @author - Madeleine Saucier
 */
package assg9_saucierm20;

import java.util.*;
import java.io.*;


public class CustomerRoster {
	
	private BinarySearchTree<Customer, String> roster;

	/*
	 * default constructor
	 */
	public CustomerRoster() {
		roster = new BinarySearchTree<Customer, String>();
	}
	
	/*
	 * add a customer
	 * @param customer to be added to roster
	 */
	public void addCustomer(Customer c) {
		roster.insert(c);
	}
	
	/*
	 * delete a customer
	 * @param id of customer to be deleted from roster
	 */
	public void deleteCustomer(String key) {
		roster.delete(key);
	}
	
	/*
	 * search for a customer
	 * @param id of customer to search for
	 * @return true if customer exists, false if not
	 */
	public boolean search(String key){
		if(roster.retrieve(key) == null) {
			return false;
		}
		return true;
	}
	
	/*
	 * retrieve a customer from the roster
	 * @param id of customer to be retrieved
	 * @return the customer with given id
	 */
	public Customer getCustomer(String key){
		return roster.retrieve(key);
	}
	
	/*
	 * load data from a text file to the roster
	 * @param name of text file
	 */
	public void loadData(String filename) {
		Scanner input = null;
		String line, name, phone, key;
		StringTokenizer st;
		
		try {
			input = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening file " + filename);
			System.exit(0);
		}
		
		while(input.hasNextLine()) {
			line =  input.nextLine();
			if(!line.isBlank()) {
				st = new StringTokenizer(line);
				key = st.nextToken();
				name = st.nextToken() + " " + st.nextToken();
				phone = st.nextToken();
				
				this.addCustomer(new Customer(name, key, phone));
			}
		}
		
	}
	
	/*
	 * save data from roster to a text file
	 * @param name of text file
	 */
	public void saveData(String filename) {
		ArrayList<Customer> list = new ArrayList<Customer>();
		list = this.sort();
		
		PrintWriter outputStream = null;
		Iterator<Customer> iter = list.iterator();
		String line;
		
		try {
			outputStream = new PrintWriter(filename);
		}
		catch(IOException e) {
			System.out.println("Error opening file " + filename);
			System.exit(0);
		}
		
		while(iter.hasNext()) {
			line = iter.next().toString();
			outputStream.println(line);
		}
		
		outputStream.close();
	}
	
	/*
	 * display all of the customers in the roster
	 */
	public void display() {
		ArrayList<Customer> list = new ArrayList<Customer>();
		list = this.sort();
		
		Iterator<Customer> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
	}
	
	/*
	 * sort the roster in order of customer id
	 * @return sorted list of customers
	 */
	public ArrayList<Customer> sort(){
		ArrayList<Customer> sorted = new ArrayList<Customer>();
		
		TreeIterator<Customer> iter = new TreeIterator<Customer>(roster);
		iter.setInorder();
		
		while(iter.hasNext()) {
			sorted.add(iter.next());
		}
		
		return sorted;
	}

}
