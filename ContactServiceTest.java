package contact;  

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    // This runs before every single test
    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    // ---------- ADD TESTS ----------

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1"));
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact);   // same ID again
        });
    }

    @Test
    public void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    // ---------- DELETE TESTS ----------

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    // ---------- UPDATE TESTS ----------

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("1", "Jane");
        assertEquals("Jane", service.getContact("1").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateLastName("1", "Smith");
        assertEquals("Smith", service.getContact("1").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updatePhone("1", "0987654321");
        assertEquals("0987654321", service.getContact("1").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateAddress("1", "456 Oak Ave");
        assertEquals("456 Oak Ave", service.getContact("1").getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Jane");
        });
    }
}