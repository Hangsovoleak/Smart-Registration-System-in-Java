// This class represents a user
public class User {
    String name;
    int age;

    // Constructor to initialize user
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Convert object to string (used when saving to file)
    public String toString() {
        return name + "," + age;
    }
}
