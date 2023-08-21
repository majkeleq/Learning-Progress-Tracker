package tracker;

public class Course {
    private final int maxPoints;
    private int points = 0;

    private final String name;
    private boolean notified = false;

    public Course(int maxPoints, String name) {
        this.maxPoints = maxPoints;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNotified() {
        notified = true;
    }
    public boolean isNotified() {
        return notified;
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
