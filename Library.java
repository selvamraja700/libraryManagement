package librarymanagementtask;

import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(int bookId, String title) {
        books.add(new Book(bookId, title));
        System.out.println("Book added successfully.");
    }

    public void registerUser(int userId, String name) {
        users.add(new User(userId, name));
        System.out.println("User registered successfully.");
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null) {
            if (!book.isIssued()) {
                user.borrowBook(book);
                System.out.println("Book issued to " + user.getName());
            } else {
                System.out.println("Book already issued.");
            }
        } else {
            System.out.println("Book or User not found.");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null) {
            if (user.getBorrowedBooks().contains(book)) {
                user.returnBook(book);
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("This book was not borrowed by the user.");
            }
        } else {
            System.out.println("Book or user not found.");
        }
    }

    public void viewBooks() {
        for (Book book : books) {
            System.out.println(book.getId() + " - " + book.getTitle() + " [" + (book.isIssued() ? "Issued" : "Available") + "]");
        }
    }

    public void viewUsers() {
        for (User user : users) {
            System.out.print(user.getUserId() + " - " + user.getName() + " | Books: ");
            if (user.getBorrowedBooks().isEmpty()) {
                System.out.println("None");
            } else {
                for (Book book : user.getBorrowedBooks()) {
                    System.out.print(book.getTitle() + ", ");
                }
                System.out.println();
            }
        }
    }

    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private User findUser(int id) {
        for (User u : users) {
            if (u.getUserId() == id) return u;
        }
        return null;
    }
}
