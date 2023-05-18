import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManagement contactManagement = new ContactManagement();

        contactManagement.dataInject();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 7) {
            System.out.println("Type the number of your choice:");
            System.out.println("1. View contacts");
            System.out.println("2. Add new contact");
            System.out.println("3. Search contact by name");
            System.out.println("4. Search contact by phone");
            System.out.println("5. Edit contact by name");
            System.out.println("6. Delete contact by name");
            System.out.println("7. Quit application");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    contactManagement.displayContacts();
                    break;
                case 2:
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

                    Contact newContact = new Contact(firstName, lastName, phone, email, streetName, streetNumber);
                    contactManagement.addContact(newContact);
                    break;
                case 3:
                    System.out.print("Enter the name of the contact to search: ");
                    String searchName = scanner.next();
                    Contact foundByName = contactManagement.searchByName(searchName);
                    contactManagement.displayContact(foundByName);
                    break;
                case 4:
                    System.out.print("Enter the phone of the contact to search: ");
                    String searchPhone = scanner.next();
                    Contact foundByPhone = contactManagement.searchByPhone(searchPhone);
                    contactManagement.displayContact(foundByPhone);
                    break;
                case 5:
                    System.out.print("Enter the name of the contact to edit: ");
                    String editName = scanner.next();
                    Contact contactToEdit = contactManagement.searchByName(editName);
                    contactManagement.editContact(contactToEdit, scanner);
                    break;
                case 6:
                    System.out.print("Enter the name of the contact to delete: ");
                    String deleteName = scanner.next();
                    Contact contactToDelete = contactManagement.searchByName(deleteName);
                    contactManagement.removeContact(deleteName);
                    break;
                case 7:
                    System.out.println("Quit application.");
                    break;
                default:
                    System.out.println("Invalid selection. Please choose again.\n");
                    break;
            }
        }
        scanner.close();
    }
}
