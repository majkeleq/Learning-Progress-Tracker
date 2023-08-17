package tracker;

public class Course {
    private int points = 0;

    public Course() {
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }
}
