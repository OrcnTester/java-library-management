import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int pageCount;

    Book(String title, String author, int pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1 - Add Book");
            System.out.println("2 - List Books");
            System.out.println("3 - Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // skip newline

            if (choice == 1) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();

                System.out.print("Enter author name: ");
                String author = scanner.nextLine();

                System.out.print("Enter page count: ");
                int pageCount = 0;
                try {
                    pageCount = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number, setting page count to 0.");
                }

                Book book = new Book(title, author, pageCount);
                library.add(book);
                System.out.println("Book added successfully!");

            } else if (choice == 2) {
                if (library.isEmpty()) {
                    System.out.println("Library is empty.");
                } else {
                    System.out.println("\n=== Book List ===");
                    for (int i = 0; i < library.size(); i++) {
                        Book b = library.get(i);
                        System.out.println((i + 1) + ". " + b.title + " by " + b.author + " (" + b.pageCount + " pages)");
                    }
                }

            } else if (choice == 3) {
                running = false;
                System.out.println("Exiting program...");
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }
}