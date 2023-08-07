package tracker.studentsHandling;

import java.util.Arrays;
import java.util.Scanner;

public class StudentsAdder {
    public StudentsAdder() {
    }
    public void addStudents(Scanner sc) {
        System.out.println("Enter student credentials or 'back' to return:");
        String input = sc.nextLine();
        int count = 0;
        while (!input.equals("back")) {
            if(addStudent(input)) {
                count++;
            }
            input = sc.nextLine();
        }
        System.out.printf("Total %d students have been added\n", count);
    }
    boolean addStudent(String input) {
        if (!validateLength(input)) {
            System.out.println("Incorrect credentials.");
            return false;
        } else {
            String[] words = input.trim().split(" ");
            String firstName = words[0];
            String lastName = String.join(" ",Arrays.copyOfRange(words, 1, words.length - 1));
            String email = words[words.length - 1];
            if (!validateNames(firstName)) {
                System.out.println("Incorrect first name.");
                return false;
            }
            if (!validateNames(lastName)) {
                System.out.println("Incorrect last name.");
                return false;
            }
            if (!validateEmail(email)) {
                System.out.println("Incorrect email.");
                return false;
            }
            System.out.println("The student has been added");
            return true;

        }
        //return validateLength(input) && validateNames(input) && validateEmail(input);
    }
    private boolean validateLength(String input) {
        return input.trim().split(" ").length >= 3;
    }
    private boolean validateNames(String input) {
        //String nameRegex = "^[A-Za-z]+(['-][A-Za-z]+)*$";
        String nameRegex = "^[A-Za-z]+(['-]?[A-Za-z]+)+$";
        //String[] words = input.trim().split(" ");
        String[] names = input.trim().split(" ");//Arrays.copyOf(words, words.length - 1);
        return Arrays.stream(names).allMatch(name -> name.matches(nameRegex));
    }
    private boolean validateEmail(String input) {
        String emailRegex = "^[A-Za-z0-9-_\\.]*@[A-Za-z0-9]+\\.[A-Za-z0-9]+$";
        String email = input.trim().split(" ")[input.trim().split(" ").length - 1];
        return email.matches(emailRegex);
    }
}
