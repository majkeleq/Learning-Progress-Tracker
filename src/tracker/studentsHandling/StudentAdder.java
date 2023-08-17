package tracker.studentsHandling;

import tracker.Student;

import java.util.Arrays;
import java.util.Set;

public class StudentAdder {
    public StudentAdder() {
    }
    Student addStudent(String input) {
        String[] words = input.trim().split(" ");
        String firstName = words[0];
        String lastName = String.join(" ", Arrays.copyOfRange(words, 1, words.length - 1));
        String email = words[words.length - 1];
        return new Student(firstName, lastName, email);
    }
    boolean isEmailTaken(String email, Set<String> emailsDatabase) {
        /*String[] words = input.trim().split(" ");
        String email = words[words.length - 1];*/
        if (emailsDatabase.contains(email)) {
            System.out.println("This email is already taken.");
            return true;
        } else {
            return false;
        }
    }

    boolean validateInput(String input) {
        if (!validateLength(input)) {
            System.out.println("Incorrect credentials.");
            return false;
        } else {
            String[] words = input.trim().split(" ");
            String firstName = words[0];
            String lastName = String.join(" ", Arrays.copyOfRange(words, 1, words.length - 1));
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
