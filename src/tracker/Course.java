package tracker;

public class Course {
    private final int maxPoints;
    private int points = 0;

    public Course(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public int getMaxPoints() {
        return maxPoints;
    }
}
