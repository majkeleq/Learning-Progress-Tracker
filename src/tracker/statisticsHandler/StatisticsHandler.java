package tracker.statisticsHandler;

import tracker.Student;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class StatisticsHandler {
    public StatisticsHandler() {
    }

    public void showStatistics(Scanner sc, Map<Integer, Student> studentsDatabase) {
        System.out.println("Type the name of a course to see details or 'back' to quit:");
        System.out.printf("Most popular: %s\n", Statistics.getMostPopularCourse());
        System.out.printf("Least popular: %s\n", Statistics.getLeastPopularCourse());
        System.out.printf("Highest activity: %s\n", Statistics.getMostActiveCourse());
        System.out.printf("Lowest activity: %s\n", Statistics.getLeastActiveCourse());
        System.out.printf("Easiest course: %s\n", Statistics.getEasiestCourse());
        System.out.printf("Hardest course: %s\n", Statistics.getHardestCourse());
        String input = sc.nextLine();
        while(!input.equals("back")) {
            temp(studentsDatabase);
            input = sc.nextLine();
        }
    }
    private void temp(Map<Integer, Student> studentsDatabase) {
        System.out.print("id\tpoints\n");
        studentsDatabase.values()
                .stream()
                .filter(student -> student.getJava().getPoints() > 0)
                .sorted(Comparator.comparingInt(s -> s.getJava().getPoints()))
                .forEach(s -> System.out.printf("%d\t%d\n",s.getId(), s.getJava().getPoints()));
    }
}
