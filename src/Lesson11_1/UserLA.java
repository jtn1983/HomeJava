package Lesson11_1;

public class UserLA extends User implements Librarian, Administrator {

    public UserLA(String name) {
        super(name);
    }

    @Override
    public void overdueNotification(Reader reader) {
        System.out.println("The librarian " + name + " notified the reader " + reader);
    }

    @Override
    public void orderBooks(Supplier supplier) {
        System.out.println("The librarian " + name + " ordered the book from " + supplier);
    }
}
