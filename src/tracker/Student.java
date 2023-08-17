package tracker;

import java.util.Objects;

public class Student {
    private static int counter = 1;
    private final int id = counter;
    private final String firstName;
    private final String lastName;

    private final String email;

    private Course java = new Course();
    private Course dsa = new Course();
    private Course db = new Course();
    private Course spring = new Course();
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        counter += 1;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public Course getJava() {
        return java;
    }

    public Course getDsa() {
        return dsa;
    }

    public Course getDb() {
        return db;
    }

    public Course getSpring() {
        return spring;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return String.format("%d points: Java=%d; DSA=%d; Databases=%d; Spring=%d", id, java.getPoints(), dsa.getPoints(), db.getPoints(), spring.getPoints());
    }
}