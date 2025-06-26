package librarymanagementtask;

import java.util.*;  // ✅ This line fixes your error

public class User {
    private int userId;
    private String name;
    private List<Book> borrowedBooks;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.issue();
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.returned();
    }
}
