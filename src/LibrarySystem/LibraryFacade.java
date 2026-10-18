package LibrarySystem;

public class LibraryFacade {
    private final Registration students = new Registration();
    private final BookManagement books = new BookManagement();
    private final History history = new History();
    private final DeadlineManagement deadlines = new DeadlineManagement();

    public void register(String name, String uniId) {
        students.register(name, uniId);
    }

    public void listbooks() {
        books.listbooks();
    }

    public void borrowBook(String uniId, String title) {
        if (!students.exists(uniId)) {
            System.out.println("Student not registered.");
            return;
        }
        if (books.borrow(title, uniId)) {
            deadlines.startLoan(uniId, title);
            history.record(uniId, title, "BORROWED");
        }
    }

    public void returnBook(String uniId, String title) {
        if (books.returnBook(title, uniId)) {
            deadlines.finishLoan(uniId, title);
            history.record(uniId, title, "RETURNED");
        }
    }

    public void viewHistory(String uniId) {
        history.studentRecords(uniId);
    }

    public void viewDeadlines(String uniId) {
        deadlines.showDeadlines(uniId);
    }
}
