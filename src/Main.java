import java.util.Scanner;

/**
 * The Main class represents the entry point of the contact management application.
 * It provides a menu-based interface for interacting with the ContactManagement system.
 */
public class Main {

    /**
     * The main method is the entry point of the application.
     * It creates an instance of the ContactManagement class, displays a menu, and handles user input.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Create an instance of the ContactManagement class
        ContactManagement contactManagement = new ContactManagement();

        // Inject some initial data into the contact management system
        contactManagement.dataInject();

        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 7) {
            // Display the menu options
            System.out.println("1. View contacts");
            System.out.println("2. Add new contact");
            System.out.println("3. Search contact by name");
            System.out.println("4. Search contact by phone");
            System.out.println("5. Edit contact by name");
            System.out.println("6. Delete contact by name");
            System.out.println("7. Quit application");
            System.out.println("Type the number of your choice:");

            // Read the user's choice
            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Display all contacts
                        contactManagement.displayContacts();
                        break;
                    case 2:
                        // Add a new contact
                        System.out.println("Enter new contact details:");
                        System.out.print("First name: ");
                        String firstName = contactManagement.validateName(scanner.next() + scanner.nextLine(), false, scanner);

                        System.out.print("Last name: ");
                        String lastName = contactManagement.validateName(scanner.next() + scanner.nextLine(), false, scanner);

                        System.out.print("Phone: ");
                        String phone = contactManagement.validateNumber(scanner.next(), "phone", scanner);

                        System.out.print("E-mail: ");
                        String email = contactManagement.validateEmail(scanner.next(), scanner);

                        System.out.print("Street name: ");
                        String streetName = contactManagement.validateName(scanner.next() + scanner.nextLine(), true, scanner);

                        System.out.print("Street number: ");
                        String streetNumber = contactManagement.validateNumber(scanner.next(), "streetNumber", scanner);

                        // Create a new Contact object with the entered details
                        Contact newContact = new Contact(firstName, lastName, phone, email, streetName, streetNumber);

                        // Add the new contact to the contact management system
                        contactManagement.addContact(newContact);
                        break;
                    case 3:
                        // Search for a contact by name
                        System.out.print("Enter the name of the contact to search: ");
                        String searchName = scanner.next();
                        Contact foundByName = contactManagement.searchByName(searchName);

                        // Display the found contact (if any)
                        contactManagement.displayContact(foundByName);
                        break;
                    case 4:
                        // Search for a contact by phone number
                        System.out.print("Enter the phone of the contact to search: ");
                        String searchPhone = scanner.next();
                        Contact foundByPhone = contactManagement.searchByPhone(searchPhone);

                        // Display the found contact (if any)
                        contactManagement.displayContact(foundByPhone);
                        break;
                    case 5:
                        // Edit a contact by name
                        System.out.print("Enter the first name of the contact to edit: ");
                        String firstNameToEdit = scanner.next();
                        System.out.print("Enter the last name of the contact to edit: ");
                        String lastNameToEdit = scanner.next();
                        Contact contactToEdit = contactManagement.searchByFullName(firstNameToEdit, lastNameToEdit);

                        // Edit the contact's details
                        contactManagement.editContact(contactToEdit, scanner);
                        break;
                    case 6:
                        // Delete a contact by name
                        System.out.print("Enter the first name of the contact to delete: ");
                        String firstNameToDelete = scanner.next();
                        System.out.print("Enter the last name of the contact to delete: ");
                        String lastNameToDelete = scanner.next();
//                        Contact contactToDelete = contactManagement.searchByFullName(firstNameToDelete, lastNameToDelete);

                        // Remove the contact from the contact management system
                        contactManagement.removeContact(firstNameToDelete, lastNameToDelete);
                        break;
                    case 7:
                        System.out.println("Quit application.");
                        break;
                    default:
                        System.out.println("Invalid selection. Please choose again.\n");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                scanner.nextLine(); // Consume the invalid input to allow the user to enter again
            }
        }

        // Close the scanner
        scanner.close();
    }
}
