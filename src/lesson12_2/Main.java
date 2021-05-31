package lesson12_2;

public class Main {
    public static void main(String[] args) {
        for (Event event : getMovies()) {
            validEvent(event);
        }

        for (Event event : getTheaters()) {
            validEvent(event);
        }

        System.out.println("That's ok!");

    }

    public static Movie[] getMovies() {
        return new Movie[] {
                new Movie("Captian America", 2011, 16),
                new Movie("World War", 2013, 18)
        };
    }

    public static Theatre[] getTheaters() {
        return new Theatre[] {
                new Theatre("Anna Karenina", 2016, 14),
                new Theatre("War and Peace", 2000, 18)
        };
    }

    public static void validEvent(Event event) {
        if (event.getTitle() == null || event.getReleaseAge() == 0 || event.getAge() == 0) {
            throw new RuntimeException();
        }
    }

}
