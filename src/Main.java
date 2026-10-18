import LibrarySystem.LibraryFacade;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibraryFacade library = new LibraryFacade();
        while (true) {
            System.out.println("\n=== UNIVERSITY LIBRARY ===");
            System.out.println("1. Register / log in");
            System.out.println("2. Exit");
            System.out.print("Choose: ");
            String choice = input.nextLine();
            if (choice.equals("2")) break;
            if (!choice.equals("1")) continue;

            System.out.print("Your name: ");
            String name = input.nextLine().trim();
            System.out.print("University ID: ");
            String id = input.nextLine().trim();
            if (name.isEmpty() || id.isEmpty()) {
                System.out.println("Name and university ID cannot be empty.");
                continue;
            }
            library.register(name, id);

            while (true) {
                System.out.println("\n1. View books  2. Borrow  3. Return");
                System.out.println("4. My history  5. My deadlines  6. Log out");
                System.out.print("Choose: ");
                String action = input.nextLine();
                if (action.equals("6")) break;
                switch (action) {
                    case "1" -> library.listbooks();
                    case "2" -> {
                        System.out.print("Book title: ");
                        library.borrowBook(id, input.nextLine().trim());
                    }
                    case "3" -> {
                        System.out.print("Book title: ");
                        library.returnBook(id, input.nextLine().trim());
                    }
                    case "4" -> library.viewHistory(id);
                    case "5" -> library.viewDeadlines(id);
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
        System.out.println("Goodbye!");
        input.close();
    }
}
