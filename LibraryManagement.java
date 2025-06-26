package librarymanagementtask;

import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Library l = new Library();

        while (true) {
            System.out.println("\n======= Library Menu =======");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. View Users");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int ch = scan.nextInt();
            scan.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Book Title: ");
                    String btitle = scan.nextLine();
                    l.addBook(bid, btitle);
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter User Name: ");
                    String uname = scan.nextLine();
                    l.registerUser(uid, uname);
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueBookId = scan.nextInt();
                    System.out.print("Enter User ID: ");
                    int issueUserId = scan.nextInt();
                    l.issueBook(issueBookId, issueUserId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = scan.nextInt();
                    System.out.print("Enter User ID: ");
                    int returnUserId = scan.nextInt();
                    l.returnBook(returnBookId, returnUserId);
                    break;
                case 5:
                    l.viewBooks();
                    break;
                case 6:
                    l.viewUsers();
                    break;
                case 7:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
