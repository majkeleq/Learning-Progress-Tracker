package tracker.statisticsHandler;

import tracker.Course;
import tracker.Student;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

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
            switch (input.toLowerCase()) {
                case "java" -> {
                    System.out.println("Java");
                    getCourseDetails(studentsDatabase, Student::getJava);
                }
                case "dsa" -> {
                    System.out.println("DSA");
                    getCourseDetails(studentsDatabase, Student::getDsa);
                }
                case "databases" -> {
                    System.out.println("Databases");
                    getCourseDetails(studentsDatabase, Student::getDb);
                }
                case "spring" -> {
                    System.out.println("Spring");
                    getCourseDetails(studentsDatabase, Student::getSpring);
                }
                default -> System.out.println("Unknown course.");

            }
            input = sc.nextLine();
        }
    }
    private void getCourseDetails(Map<Integer, Student> studentsDatabase, Function<Student,Course> getCourse) {
        System.out.print("id\tpoints\tcompleted\n");

        studentsDatabase.values()
                .stream()
                .filter(student -> getCourse.apply(student).getPoints() > 0)
                //.sorted(Comparator.comparingInt(s -> s.getJava().getCourse()))
                //.sorted((s1,s2)-> Integer.compare(s2.getJava().getCourse(), s1.getJava().getCourse()))
                .sorted((s1,s2)-> Integer.compare(getCourse.apply(s2).getPoints(), getCourse.apply(s1).getPoints()))
                .forEach(s -> {
                    BigDecimal completed = BigDecimal.valueOf((double) (getCourse.apply(s).getPoints() * 100) / getCourse.apply(s).getMaxPoints()).setScale(1,RoundingMode.HALF_UP);
                    //Double completed = (double) (getCourse.apply(s).getPoints() * 100)/getCourse.apply(s).getMaxPoints();
                    System.out.printf("%d\t%d\t%s%%\n",s.getId(), getCourse.apply(s).getPoints(),
                        completed);
                });
    }
}
