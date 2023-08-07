package tracker.studentsHandling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentsAdderTest {


    @Test
    @DisplayName("Test length shorter than 3 words, should be FALSE")
    void validateLengthShorterThan3Words() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jean Claude";
        boolean result = studentsAdder.addStudent(input);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test length with 3 words, should be TRUE")
    void validateLength3Words() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jean Claude mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test length with more than 3 words, should be TRUE")
    void validateMoreThan3Words() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jean Claude Example mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test name: 'Jean Claude', should be TRUE")
    void validateName1() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jean Claude mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test name: 'Jean C.', should be FALSE")
    void validateName2() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jean C. mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertFalse(result);
    }
    @Test
    @DisplayName("Test name: 'Jean-Claude', should be FALSE")
    void validateName3() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jean-Claude mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertFalse(result);
    }
    @Test
    @DisplayName("Test name: 'Jean-Claude van Damme', should be TRUE")
    void validateName4() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jean-Claude van Damme mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test name: 'Jack O'Neill', should be TRUE")
    void validateName5() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jack O'Neill mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test name: 'Jack O' Neill', should be FALSE")
    void validateName6() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jack O' Neill mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertFalse(result);
    }
    @Test
    @DisplayName("Test mail: mail@example, should be FALSE")
    void validateMail1() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jack O'Neill mail@example";
        boolean result = studentsAdder.addStudent(input);
        assertFalse(result);
    }
    @Test
    @DisplayName("Test mail: mail@example.com, should be TRUE")
    void validateMail2() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jack O'Neill mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test mail: mail-mail@example.com, should be TRUE")
    void validateMail3() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jack O'Neill mail-mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test mail: mail_mail@example.com, should be TRUE")
    void validateMail4() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jack O'Neill mail_mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test mail: mail.mail@example.com, should be TRUE")
    void validateMail5() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jack O'Neill mail.mail@example.com";
        boolean result = studentsAdder.addStudent(input);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test mail: mail@example_mail.com, should be FALSE")
    void validateMail6() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jack O'Neill mail@example_mail.com";
        boolean result = studentsAdder.addStudent(input);
        assertFalse(result);
    }
    @Test
    @DisplayName("Test mail: mail@example1.com1, should be True")
    void validateMail7() {
        StudentsAdder studentsAdder = new StudentsAdder();
        String input = "Jack O'Neill mail@example1.com1";
        boolean result = studentsAdder.addStudent(input);
        assertTrue(result);
    }
}