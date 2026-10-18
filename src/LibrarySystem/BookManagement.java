package LibrarySystem;

import java.util.HashMap;

public class BookManagement implements LibraryService {
    // Book title -> university ID of borrower; null means available.
    private final HashMap<String, String> books = new HashMap<>();

    public BookManagement() {
        books.put("Clean Code", null);
        books.put("Design Patterns", null);
        books.put("Effective Java", null);
        books.put("Introduction to Algorithms", null);
    }

    public boolean borrow(String title, String uniId) {
        if (!books.containsKey(title)) {
            System.out.println("Book not found. Choose another title.");
            return false;
        }
        if (books.get(title) != null) {
            System.out.println("Book unavailable. Choose another title.");
            return false;
        }
        books.put(title, uniId);
        System.out.println("Borrowed: " + title);
        return true;
    }

    public boolean returnBook(String title, String uniId) {
        if (!books.containsKey(title) || !uniId.equals(books.get(title))) {
            System.out.println("You haven't borrowed this book.");
            return false;
        }
        books.put(title, null);
        System.out.println("Returned: " + title);
        return true;
    }

    public void listbooks() {
        for (String title : books.keySet()) {
            System.out.println(title + " - " + (books.get(title) == null ? "Available" : "Unavailable"));
        }
    }

    @Override
    public void summary() {
        listbooks();
    }
}
