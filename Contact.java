package contact;

public class Contact {

	private final String contactID; // final after private means once the ID is set it can't be changed
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		// Validate the contactID checks for null and less than 10 characters
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		// Validate first name checks for null and less than 10 characters
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		// Validate last name checks for null and less than 10 characters
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		// Validate phone checks for null, length of 10, and contains digits
		if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		// Validate address checks for null and less than 30 characters
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		// Stores values after checks are completed
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Gets contactID
	public String getContactID() {
		return contactID;
	}
	// Gets first name
	public String getFirstName() {
		return firstName;
	}
	// Gets last name
	public String getLastName() {
		return lastName;
	}
	// Gets phone number
	public String getPhone() {
		return phone;
	}
	// Gets address
	public String getAddress() {
		return address;
	}
	
	// Sets first name
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	// Sets last name
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;
	}
	// Sets phone number
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		this.phone = phone;
	}
	// Sets address
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
}
