package Lesson11_1;

public class Main {
    public static void main(String[] args) {
        UserRS readerSupplier = new UserRS("Mike");
        UserLA librarianAdmin = new UserLA("Steve");

        readerSupplier.tookBook(librarianAdmin);
        librarianAdmin.overdueNotification(readerSupplier);
        readerSupplier.returnBook(librarianAdmin);
    }
}
