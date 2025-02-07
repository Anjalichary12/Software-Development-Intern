import java.util.*;
import java.io.*;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManager {
    private static final String FILE_NAME = "contacts.txt";
    private static List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        loadContacts();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nContact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact(scanner);
                    break;
                case 4:
                    deleteContact(scanner);
                    break;
                case 5:
                    saveContacts();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    private static void editContact(Scanner scanner) {
        viewContacts();
        System.out.print("Enter contact number to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter new name: ");
            contacts.get(index).name = scanner.nextLine();
            System.out.print("Enter new phone: ");
            contacts.get(index).phone = scanner.nextLine();
            System.out.print("Enter new email: ");
            contacts.get(index).email = scanner.nextLine();
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    private static void deleteContact(Scanner scanner) {
        viewContacts();
        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    private static void saveContacts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contacts) {
                writer.println(contact.name + "," + contact.phone + "," + contact.email);
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts.");
        }
    }

    private static void loadContacts() {
        try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                if (data.length == 3) {
                    contacts.add(new Contact(data[0], data[1], data[2]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing contacts found.");
        }
    }
}
