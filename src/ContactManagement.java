import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            System.out.print("Enter new first name: ");
            String newFirstName = validateName(scanner.next()+ scanner.nextLine(), false, scanner);
            contactToEdit.setFirstName(newFirstName);

            System.out.print("Enter new last name: ");
            String newLastName = validateName(scanner.next() + scanner.nextLine(), false, scanner);
            contactToEdit.setLastName(newLastName);

            System.out.print("Enter new phone: ");
            String newPhone = validateNumber(scanner.next(), "phone", scanner);
            contactToEdit.setPhone(newPhone);

            System.out.print("Enter new e-mail: ");
            String newEmail = validateEmail(scanner.next(), scanner);
            contactToEdit.setEmail(newEmail);

            System.out.print("Enter new street name: ");
            String newStreetName = validateName(scanner.next() + scanner.nextLine(), true, scanner);
            contactToEdit.setStreetName(newStreetName);

            System.out.print("Enter new street number: ");
            String newStreetNumber = validateNumber(scanner.next(), "streetNumber", scanner);
            contactToEdit.setStreetNumber(newStreetNumber);

            System.out.println(BOLD + ITALIC + YELLOW + "Contact edited successfully!\n" + RESET);
        } else {
            System.out.println(BOLD + ITALIC + BLUE + "Contact not found.\n" + RESET);
        }
    }

    public void removeContact(String firstName, String lastName) {
        Contact contactToRemove = null;
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                contactToRemove = contact;
                break;
            }
        }
        if (contactToRemove != null) {
            contacts.remove(contactToRemove);
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
            System.out.println(BOLD + ITALIC + BLUE + "There are no contacts." + RESET);
        } else {
            int contactsCount = contacts.size();  // Get the number of contacts
            System.out.println(BOLD + ITALIC + CYAN + contactsCount + " contact" + (contactsCount > 1 ? "s" : "") + " found:" + RESET);

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

    // Validation methods
    public String validateName(String name, boolean includingSpace, Scanner scanner) {
        if (includingSpace) {
            while (!isValidStreetName(name)) {
                System.out.print("Invalid street name. Please enter a valid street name: ");
                name = scanner.next() + scanner.nextLine();
            }
        } else {
            while (!isValidName(name)) {
                System.out.print("Invalid name. Please enter a valid name: ");
                name = scanner.next() + scanner.nextLine();
            }
        }
        return name;
    }

    public boolean isValidName(String name) {
        return name.matches("[A-Z][a-z]*");
    }

    public boolean isValidStreetName(String name) {
        return name.matches("[A-Z][a-z ]+[A-Z]?[a-z]*");
    }

    public String validateNumber(String number, String type, Scanner scanner) {
        while (!isValidNumber(number, type)) {
            System.out.print("Invalid number. Please enter a valid number: ");
            number = scanner.next();
        }
        return number;
    }

    public boolean isValidNumber(String number, String type) {
        if (number.length() != 10 && type.equals("phone")) {
            return false;
        } else if (number.length() > 3 && type.equals("streetNumber")) {
            return false;
        }

        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public String validateEmail(String email, Scanner scanner) {
        while (!isValidEmail(email)) {
            System.out.print("Invalid email. Please enter a valid email: ");
            email = scanner.next();
        }
        return email;
    }

    public boolean isValidEmail(String email) {
        // Regular expression pattern for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[a-z]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Data injection method
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
