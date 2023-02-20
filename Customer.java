/*
 * a class for a Customer
 * @author - Madeleine Saucier
 */
package assg9_saucierm20;

public class Customer extends KeyedItem<String>{
	
	private String name;
	private String phone;
	
	/*
	 * default constructor
	 * @param name of customer, customer id, customer phone number
	 */
	public Customer(String newName, String id, String newNum) {
		super(id);
		name = newName;
		phone = newNum;
	}
	
	/*
	 * retrieve customer name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * retrieve customer phone number
	 * @return phone number
	 */
	public String getNum() {
		return phone;
	}
	
	/*
	 * change customer name
	 * @param new customer name
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/*
	 * change customer phone number
	 * @param new customer phone number
	 */
	public void setNum(String newNum) {
		phone = newNum;
	}
	
	/*
	 * show all customer info in a string
	 * @return strind with customer id, name and phone number separated by tab
	 */
	public String toString() {
		return this.getKey() + "\t" + name + "\t" + phone;
	}
}
