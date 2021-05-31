package Lesson11_1;

public class UserRS extends User implements Reader, Supplier{
    public UserRS(String name) {
        super(name);
    }

    @Override
    public void tookBook(Librarian librarian) {
        System.out.println("The user-supplier " + name + " took the book from the librarian " + librarian);
    }

    @Override
    public void returnBook(Librarian librarian) {
        System.out.println("The user-supplier " + name + " returned the book to the librarian " + librarian);
    }

    @Override
    public void bringBooks(Administrator administrator) {
        System.out.println("The user-supplier " + name + " brought the book to the administrator " + administrator);
    }
}
