package lesson12_2;

abstract class Event {
    private String title;
    private int releaseAge;
    private int age;

    public Event (String title, int releaseAge, int age) {
        this.title = title;
        this.age = age;
        this.releaseAge = releaseAge;
    }

    @Override
    public String toString() {
        return "[Title: " + title +
                "Release Age: " +releaseAge +
                "Age: " +age + "]";
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseAge() {
        return releaseAge;
    }

    public int getAge() {
        return age;
    }
}
