package LibrarySystem;

import java.util.ArrayList;

public class History implements LibraryService {
    private final ArrayList<String> history = new ArrayList<>();

    public void record(String uniId, String title, String action) {
        history.add(uniId + " | " + action + " | " + title);
    }

    public void studentRecords(String uniId) {
        boolean found = false;
        for (String entry : history) {
            if (entry.startsWith(uniId + " | ")) {
                System.out.println(entry);
                found = true;
            }
        }
        if (!found) System.out.println("No history yet.");
    }

    @Override
    public void summary() {
        System.out.println("Total recorded actions: " + history.size());
    }
}
