package tracker;

import tracker.statisticsHandler.Statistics;
import tracker.statisticsHandler.StatisticsHandler;
import tracker.studentsHandling.StudentsHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentsHandler studentsHandler = new StudentsHandler();
        StatisticsHandler statisticsHandler = new StatisticsHandler();
        boolean toContinue = true;
        System.out.println("Learning Progress Tracker");
        while (toContinue) {
            switch (sc.nextLine().trim()) {
                case "" -> System.out.println("No input.");
                case "add students" -> studentsHandler.addStudents(sc);
                case "add points" -> studentsHandler.addPoints(sc);
                case "list" -> studentsHandler.listStudents();
                case "find" -> studentsHandler.findStudent(sc);
                case "statistics" -> statisticsHandler.showStatistics(sc, studentsHandler.getStudentsDatabase());
                case "back" -> System.out.println("Enter 'exit' to exit the program");
                case "exit" -> {
                    System.out.println("Bye!");
                    toContinue = false;
                }
                default -> System.out.println("Unknown command!");
            }
        }
    }
}
