import java.util.Scanner;

public class Main {
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
                    String firstName = scanner.next();
                    System.out.print("Last name: ");
                    String lastName = scanner.next();
                    System.out.print("Phone: ");
                    String phone = scanner.next();
                    System.out.print("E-mail: ");
                    String email = scanner.next();
                    System.out.print("Street name: ");
                    String streetName = scanner.next();
                    System.out.print("Street number: ");
                    String streetNumber = scanner.next();

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

                    // Remove the contact from the contact management system
                    contactManagement.deleteContact(firstNameToDelete, lastNameToDelete);
                    break;
                case 7:
                    System.out.println("Quit application.");
                    break;
                default:
                    System.out.println("Invalid selection. Please choose again.\n");
                    break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}
