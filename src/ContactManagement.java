import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagement {

    private final ArrayList<Contact> contacts;

    public ContactManagement() {
        contacts = new ArrayList<>();
    }

    //  Console font formatting
    public static final String BOLD = "\u001B[1m";
    public static final String ITALIC = "\u001B[3m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String MAGENTA = "\u001B[35m";

    private int counter = 0;

    /**
     * Adds a contact to the list of contacts.
     * If the counter is greater than or equal to 10, it prints a success message.
     * If the counter is less than 10, it increments the counter.
     * The counter keeps track of the number of contacts added.
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
        if (counter >= 10) {
            System.out.println(BOLD + ITALIC + GREEN + "Contact added successfully!\n" + RESET);
        }
        if (counter < 10) {
            counter++;
        }
    }

    public void editContact(Contact contactToEdit, Scanner scanner) {
        if (contactToEdit != null) {
            System.out.print("Enter new phone: ");
            String newPhone = scanner.next();
            contactToEdit.setPhone(newPhone);
            System.out.println(BOLD + ITALIC + YELLOW + "Contact edited successfully!\n" + RESET);
        } else {
            System.out.println(BOLD + ITALIC + BLUE + "Contact not found.\n" + RESET);
        }
    }

    public void deleteContact(String firstName, String lastName) {
        Contact contactToDelete = searchByFullName(firstName,lastName);

        if (contactToDelete != null) {
            contacts.remove(contactToDelete);
            System.out.println(BOLD + ITALIC + RED + "Contact deleted successfully!\n" + RESET);
        } else {
            System.out.println(BOLD + ITALIC + BLUE + "Contact not found.\n" + RESET);
        }
    }

    public Contact searchByName(String firstName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchByFullName(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchByPhone(String phone) {
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)) {
                return contact;
            }
        }
        return null;
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println(BOLD + ITALIC + BLUE + "There are no contacts saved." + RESET);
        } else {
            int contactsCount = contacts.size();  // Get the number of contacts to display
            System.out.println(BOLD + ITALIC + CYAN + contactsCount +
                    " contact" + (contactsCount > 1 ? "s" : "") + " found:" + RESET);
            for (Contact contact : contacts) {
                contactDetails(contact);
            }
        }
    }

    public void displayContact(Contact searchParam) {
        if (searchParam != null) {
            System.out.println(BOLD + ITALIC + CYAN + "Contact found:" + RESET);
            contactDetails(searchParam);
        } else {
            System.out.println(BOLD + ITALIC + BLUE + "Contact not found.\n" + RESET);
        }
    }

    protected void contactDetails(Contact contact) {
        System.out.println("First name: " + contact.getFirstName());
        System.out.println("Last name: " + contact.getLastName());
        System.out.println("Phone: " + contact.getPhone());
        System.out.println("E-mail: " + contact.getEmail());
        System.out.println("Street name: " + contact.getStreetName());
        System.out.println("Street number: " + contact.getStreetNumber());
        System.out.println("------------------------");
    }

    public void dataInject() {
        // Create sample contact objects
        Contact contact1 = new Contact("John", "Smith", "1234567890", "john@example.com", "Main", "123");
        Contact contact2 = new Contact("Jane", "Doe", "9876543210", "jane@example.com", "Elm", "456");
        Contact contact3 = new Contact("Mike", "Johnson", "5555555555", "mike@example.com", "Oak", "789");
        Contact contact4 = new Contact("Robert", "Johnson", "9999999999", "robert@example.com", "Willow", "789");
        Contact contact5 = new Contact("Emily", "Davis", "1112223333", "emily@example.com", "Pine", "123");
        Contact contact6 = new Contact("Sarah", "Wilson", "5551112222", "sarah@example.com", "Cedar", "789");
        Contact contact7 = new Contact("David", "Brown", "9998887777", "david@example.com", "Oak", "789");
        Contact contact8 = new Contact("Jennifer", "Taylor", "4443332222", "jennifer@example.com", "Birch", "123");
        Contact contact9 = new Contact("Michael", "Anderson", "7776665555", "michael@example.com", "Willow", "789");
        Contact contact10 = new Contact("Jessica", "Martinez", "2223334444", "jessica@example.com", "Maple", "456");

        // Add sample contacts to the list
        addContact(contact1);
        addContact(contact2);
        addContact(contact3);
        addContact(contact4);
        addContact(contact5);
        addContact(contact6);
        addContact(contact7);
        addContact(contact8);
        addContact(contact9);
        addContact(contact10);
    }
}
