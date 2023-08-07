package tracker;

import tracker.studentsHandling.StudentsAdder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean toContinue = true;
        System.out.println("Learning Progress Tracker");
        while (toContinue) {
            switch (sc.nextLine().trim()) {
                case "" -> System.out.println("No input.");
                case "add students" -> {
                    StudentsAdder studentsAdder = new StudentsAdder();
                    studentsAdder.addStudents(sc);
                }
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
