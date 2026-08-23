package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	// stores the contact IDs
	private final Map<String, Contact> contacts = new HashMap<>();
	
	// add a new contact
	public void addContact(Contact contact) {
		if (contact == null || contacts.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Contact already exists or is null");
		}
		contacts.put(contact.getContactID(), contact);
	}
	
	// delete a contact
	public void deleteContact(String contactID) {
		if (contactID == null || !contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		contacts.remove(contactID);
	}
	
	// update first name
	public void updateFirstName(String contactID, String firstName) {
		Contact contact = getContactOrThrow(contactID);
		contact.setFirstName(firstName);
	}
	
	// update last name
	public void updateLastName(String contactID, String lastName) {
		Contact contact = getContactOrThrow(contactID);
		contact.setLastName(lastName);
	}
	
	// update phone
	public void updatePhone(String contactID, String phone) {
		Contact contact = getContactOrThrow(contactID);
		contact.setPhone(phone);
	}
	
	// update address
	public void updateAddress(String contactID, String address) {
		Contact contact = getContactOrThrow(contactID);
		contact.setAddress(address);
	}
	
	// private helper method to avoid redundancy
	private Contact getContactOrThrow(String contactID) {
		if (contactID == null || !contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		return contacts.get(contactID);
	}
	
	// gets whole contact good for testing
	public Contact getContact(String contactID) {
		return contacts.get(contactID);
	}
	
}
