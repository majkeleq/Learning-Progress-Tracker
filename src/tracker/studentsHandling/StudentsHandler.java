package tracker.studentsHandling;

import tracker.Student;

import java.util.*;

public class StudentsHandler {
    private final Map<Integer, Student> studentsDatabase = new LinkedHashMap<>();

    Set<String> emailsDatabase = new HashSet<>();
    public StudentsHandler() {
    }

    public Map<Integer, Student> getStudentsDatabase() {
        return studentsDatabase;
    }

    public void addStudents(Scanner sc) {
        System.out.println("Enter student credentials or 'back' to return:");
        String input = sc.nextLine();
        StudentAdder studentAdder = new StudentAdder();
        int count = 0;
        while (!input.equals("back")) {
            if (studentAdder.validateInput(input)
                    && !studentAdder.isEmailTaken(input.trim().split(" ")[input.trim().split(" ").length - 1], emailsDatabase)) {
                Student student = studentAdder.addStudent(input);
                studentsDatabase.put(student.getId(), student);
                emailsDatabase.add(student.getEmail());
                System.out.println("The student has been added.");
                count++;
            }
            input = sc.nextLine();
        }
        System.out.printf("Total %d students have been added.\n", count);
    }

    public void findStudent(Scanner sc) {
        System.out.println("Enter an id or 'back' to return:");
        String input = sc.nextLine();
        while (!input.equals("back")) {
            Student student = studentsDatabase.getOrDefault(Integer.parseInt(input), null);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.printf("No student is found for id=%s\n", input);
            }
            input = sc.nextLine();
        }
    }

    public void listStudents() {
        if (studentsDatabase.size() == 0) {
            System.out.println("No students found.");
        } else {
            System.out.println("Students:");
            studentsDatabase.values().forEach(s -> System.out.println(s.getId()));
        }
    }

    public void addPoints(Scanner sc) {
        System.out.println("Enter an id and points or 'back' to return:");
        String input = sc.nextLine();
        while (!input.equals("back")) {
            String inputRegex = "^[A-Za-z0-9]+ [0-9]+ [0-9]+ [0-9]+ [0-9]+$";
            if (input.matches(inputRegex)) {
                String[] inputParts = input.split(" ");
                try {
                    Student student = studentsDatabase.getOrDefault(Integer.parseInt(inputParts[0]), null);
                    student.addPointsJava(Integer.parseInt(inputParts[inputParts.length - 4]));
                    student.addPointsDSA(Integer.parseInt(inputParts[inputParts.length - 3]));
                    student.addPointsDB(Integer.parseInt(inputParts[inputParts.length - 2]));
                    student.addPointsSpring(Integer.parseInt(inputParts[inputParts.length - 1]));
                    System.out.println("Points updated.");

                } catch (Exception e) {
                    System.out.printf("No student is found for id=%s.\n", inputParts[0]);
                }
            } else {
                System.out.println("Incorrect points format.");
            }
            input = sc.nextLine();
        }
    }
}
