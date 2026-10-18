package LibrarySystem;

import java.time.LocalDate;
import java.util.HashMap;

public class DeadlineManagement implements LibraryService {
    private final HashMap<String, LocalDate> deadlines = new HashMap<>();

    private String key(String uniId, String title) {
        return uniId + " | " + title;
    }

    public void startLoan(String uniId, String title) {
        LocalDate due = LocalDate.now().plusDays(14);
        deadlines.put(key(uniId, title), due);
        System.out.println("Return before: " + due);
    }

    public void finishLoan(String uniId, String title) {
        LocalDate due = deadlines.remove(key(uniId, title));
        if (due != null && LocalDate.now().isAfter(due)) {
            System.out.println("This book was returned late.");
        }
    }

    public void showDeadlines(String uniId) {
        boolean found = false;
        for (String loan : deadlines.keySet()) {
            if (loan.startsWith(uniId + " | ")) {
                LocalDate due = deadlines.get(loan);
                System.out.println(loan.substring((uniId + " | ").length()) + " - due " + due
                        + (LocalDate.now().isAfter(due) ? " (OVERDUE)" : ""));
                found = true;
            }
        }
        if (!found) System.out.println("No books currently borrowed.");
    }

    @Override
    public void summary() {
        System.out.println("Active loans: " + deadlines.size());
    }
}
