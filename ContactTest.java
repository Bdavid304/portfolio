package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ContactTest {

	// creates valid contact with valid data
	@Test
	public void testValidContact() {
		Contact contact = new Contact("1234567890", "John", "Jones", "3036789864", "132 Main Street");
		assertEquals("1234567890", contact.getContactID());
		assertEquals("John", contact.getFirstName());
		assertEquals("Jones", contact.getLastName());
		assertEquals("3036789864", contact.getPhone());
		assertEquals("132 Main Street", contact.getAddress());
	}
	
	// test long contact ID
	@Test
    public void testContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Jones", "3036789864", "132 Main Street");
        });
    }

	// tests null contact ID
    @Test
    public void testContactIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Jones", "3036789864", "132 Main Street");
        });
    }

    // tests long first name
    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Johnnnnnnnn", "Jones", "3036789864", "132 Main Street");
        });
    }

    // tests null first name
    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Jones", "3036789864", "132 Main Street");
        });
    }

    // tests long last name
    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Joneseeeeeeee", "3036789864", "132 Main Street");
        });
    }

    // tests null last name
    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", null, "3036789864", "132 Main Street");
        });
    }

    // tests invalid phone length
    @Test
    public void testPhoneNot10Digits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Jones", "303678986", "132 Main Street");
        });
    }

    // tests null phone number
    @Test
    public void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Jones", null, "132 Main Street");
        });
    }

    // tests long address
    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Jones", "3036789864", "132 Main Street that is way too long for the limit");
        });
    }

    // tests null addressS
    @Test
    public void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Jones", "3036789864", null);
        });
    }
}
