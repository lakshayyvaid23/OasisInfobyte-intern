package DigitalLibraryManagement;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

class Customer {
    String name;
    String customerId;
    String libraryCardId;
    ArrayList<Book> borrowedBooks;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.libraryCardId = "";
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable) {
            book.isAvailable = false;
            borrowedBooks.add(book);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.isAvailable = true;
            borrowedBooks.remove(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("You have not borrowed this book.");
        }
    }
}

class Admin {
    ArrayList<Book> books;
    ArrayList<Customer> customers;

    public Admin() {
        this.books = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void deleteBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void viewBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", Author: " + book.author + ", Available: " + book.isAvailable);
        }
    }

    public void issueLibraryCard(Customer customer) {
        customer.libraryCardId = "LC-" + customer.customerId;
        System.out.println("Library card issued successfully. Card ID: " + customer.libraryCardId);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public void viewCustomers() {
        for (Customer customer : customers) {
            System.out.println("Name: " + customer.name + ", Customer ID: " + customer.customerId + ", Library Card ID: " + customer.libraryCardId);
        }
    }
}

public class DigitalLibraryManagement {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Delete book");
            System.out.println("3. View books");
            System.out.println("4. Add customer");
            System.out.println("5. Issue library card");
            System.out.println("6. View customers");
            System.out.println("7. Borrow book");
            System.out.println("8. Return book");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(title, author);
                    admin.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    author = scanner.nextLine();
                    book = new Book(title, author);
                    admin.deleteBook(book);
                    break;
                case 3:
                    admin.viewBooks();
                    break;
                case 4:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    String customerId = scanner.nextLine();
                    Customer customer = new Customer(name, customerId);
                    admin.addCustomer(customer);
                    break;
                case 5:
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextLine();
                    for (Customer c : admin.customers) {
                        if (c.customerId.equals(customerId)) {
                            admin.issueLibraryCard(c);
                            break;
                        }
                    }
                    break;
                case 6:
                    admin.viewCustomers();
                    break;
                case 7:
                    System.out.print(" Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    author = scanner.nextLine();
                    book = new Book(title, author);
                    System.out.print(" Enter customer ID: ");
                    customerId = scanner.nextLine();
                    for (Customer c : admin.customers) {
                        if (c.customerId.equals(customerId)) {
                            c.borrowBook(book);
                            break;
                        }
                    }
                    break;
                case 8:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    author = scanner.nextLine();
                    book = new Book(title, author);
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextLine();
                    for (Customer c : admin.customers) {
                        if (c.customerId.equals(customerId)) {
                            c.returnBook(book);
                            break;
                        }
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}