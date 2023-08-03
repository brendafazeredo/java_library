package java_library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class library {
    private List<book> books;

    public library() {
        books = new ArrayList<>();
    }

    public void addBook(book book) {
        books.add(book);
    }

    public void removeBook(book book) {
        books.remove(book);
    }

    public book findBookByTitle(String title) {
        for (book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public book findBookByAuthor(String author) {
        for (book book : books) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public book findBookByYear(int year) {
        for (book book : books) {
            if (book.getYear() == year) {
                return book;
            }
        }
        return null;
    }

    public book findBookByIsbn(String isbn) {
        for (book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        library library = new library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Library Management System -----");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Find Book by Author");
            System.out.println("5. Find Book by Year");
            System.out.println("6. Find Book by ISBN");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    book book = new book(title, author, year, isbn);
                    library.addBook(book);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Title of the Book to remove: ");
                    String titleToRemove = scanner.nextLine();
                    book bookToRemove = library.findBookByTitle(titleToRemove);
                    if (bookToRemove != null) {
                        library.removeBook(bookToRemove);
                        System.out.println("Book removed successfully!");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Title to search: ");
                    String titleToSearch = scanner.nextLine();
                    book bookByTitle = library.findBookByTitle(titleToSearch);
                    if (bookByTitle != null) {
                        System.out.println("Book Found: " + bookByTitle);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Author to search: ");
                    String authorToSearch = scanner.nextLine();
                    book bookByAuthor = library.findBookByAuthor(authorToSearch);
                    if (bookByAuthor != null) {
                        System.out.println("Book Found: " + bookByAuthor);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Year to search: ");
                    int yearToSearch = scanner.nextInt();
                    scanner.nextLine();
                    book bookByYear = library.findBookByYear(yearToSearch);
                    if (bookByYear != null) {
                        System.out.println("Book Found: " + bookByYear);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter ISBN to search: ");
                    String isbnToSearch = scanner.nextLine();
                    book bookByIsbn = library.findBookByIsbn(isbnToSearch);
                    if (bookByIsbn != null) {
                        System.out.println("Book Found: " + bookByIsbn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}