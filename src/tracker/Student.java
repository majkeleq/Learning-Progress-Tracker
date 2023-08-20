package tracker;

import tracker.statisticsHandler.Statistics;

import java.util.Objects;

public class Student {
    private static int counter = 1;
    private final int id = counter;
    private final String firstName;
    private final String lastName;

    private final String email;

    private final Course java = new Course(600);
    private final Course dsa = new Course(400);
    private final Course db = new Course(480);
    private final Course spring = new Course(550);
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        counter += 1;
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

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
    public void addPointsJava(int points) {
        if (points > 0) {
            if (java.getPoints() == 0) Statistics.incrementJavaPopularity();
            Statistics.incrementJavaActivity();
            Statistics.addJavaPoints(points);
            java.addPoints(points);
        }
    }
    public void addPointsDSA(int points) {
        if (points > 0) {
            if (dsa.getPoints() == 0) Statistics.incrementDsaPopularity();
            Statistics.incrementDsaActivity();
            Statistics.addDsaPoints(points);
            dsa.addPoints(points);
        }
    }
    public void addPointsDB(int points) {
        if (points > 0) {
            if (db.getPoints() == 0) Statistics.incrementDbPopularity();
            Statistics.incrementDbActivity();
            Statistics.addDbPoints(points);
            db.addPoints(points);
        }
    }
    public void addPointsSpring(int points) {
        if (points > 0) {
            if (spring.getPoints() == 0) Statistics.incrementSpringPopularity();
            Statistics.incrementSpringActivity();
            Statistics.addSpringPoints(points);
            spring.addPoints(points);
        }
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
