package Lesson11_1;

public class User {
    protected String name;
    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
