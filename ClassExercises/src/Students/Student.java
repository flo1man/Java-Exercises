package Students;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String homeTown;

    public Student(String firstName, String lastName, int age, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeTown = homeTown;
    }

    public String getHomeTown(){
        return this.homeTown;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old", this.firstName, this.lastName, this.age);
    }
}
