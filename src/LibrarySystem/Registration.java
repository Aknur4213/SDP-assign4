package LibrarySystem;

import java.util.HashMap;

public class Registration implements LibraryService {
    private final HashMap<String, String> students = new HashMap<>();

    public void register(String name, String uniId) {
        if (students.containsKey(uniId)) {
            System.out.println("Welcome back, " + students.get(uniId) + "!");
        } else {
            students.put(uniId, name);
            System.out.println("New account created for " + name + ".");
        }
    }

    public boolean exists(String uniId) {
        return students.containsKey(uniId);
    }

    @Override
    public void summary() {
        System.out.println("Registered students: " + students.size());
    }
}
