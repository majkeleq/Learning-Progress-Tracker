package tracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class Notifications {
    public Notifications() {
    }

    public void notify(Map<Integer, Student> studentsDatabase) {
        int notifyCounter = 0;
        HashSet<Student> notifiedStudents = new HashSet<>();
        studentsDatabase.values().forEach(s -> {
            if (s.getJava().getPoints() == s.getJava().getMaxPoints() && !s.getJava().isNotified()) {
                s.getJava().setNotified();
                System.out.println(returnMesage(s, "Java"));
                notifiedStudents.add(s);
            }
            if (s.getDsa().getPoints() == s.getDsa().getMaxPoints() && !s.getDsa().isNotified()) {
                s.getDsa().setNotified();
                System.out.println(returnMesage(s, "DSA"));
                notifiedStudents.add(s);
            }
            if (s.getDb().getPoints() == s.getDb().getMaxPoints() && !s.getDb().isNotified()) {
                s.getDb().setNotified();
                System.out.println(returnMesage(s, "Databases"));
                notifiedStudents.add(s);
            }
            if (s.getSpring().getPoints() == s.getSpring().getMaxPoints() && !s.getSpring().isNotified()) {
                s.getSpring().setNotified();
                System.out.println(returnMesage(s, "Spring"));
                notifiedStudents.add(s);
            }
        });
        System.out.printf("Total %d students have been notified.\n", notifiedStudents.size());
    }

    private String returnMesage(Student s, String courseName) {
        return String.format("To: %s\nRe: Your Learning Progress\nHello, %s %s! You have accomplished our %s course!", s.getEmail(), s.getFirstName(), s.getLastName(), courseName);
    }
}
