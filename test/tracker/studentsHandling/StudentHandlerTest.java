package tracker.studentsHandling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentHandlerTest {


    @DisplayName("Testing Input String Validation")
    @ParameterizedTest(name = "{index} => validateInput({0}) == {1}")
    @CsvSource({"Jean Claude, false",
            "Jean Claude mail@example.com, true",
            "Jean Claude Example mail@example.com, true",
            "Jean C. mail@example.com, false",
            "Jean-Claude mail@example.com, false",
            "Jean-Claude O'Neill van Damme mail@example.com, true",
            "Jack O' Neill mail@example.com, false",
            "Jack O'Neill mail@example, false",
            "Jack O'Neill mail@example.com, true",
            "Jack O'Neill mail-m_a.il@example1.com, true",
            "Jack O'Neill mail@example_mail.com, false"})
    void testInputStringValidation(String input, boolean expected) {
        StudentAdder studentAdder = new StudentAdder();
        boolean result = studentAdder.validateInput(input);
        assertEquals(expected, result);
    }

    @DisplayName("Testing if email is taken")
    @ParameterizedTest(name = "{index} => isEmailTaken(String email, Set<String> emailsDatabase)")
    @CsvSource({"test@test.com, true",
            "test1@test.com, false",
            ",false"})
    void testIfEmailIsTaken(String email, boolean expected) {
        StudentAdder studentAdder = new StudentAdder();
        Set<String> emailsDatabase = new HashSet<>(Arrays.asList("test@test.com", "test2@test.com"));
        boolean result = studentAdder.isEmailTaken(email, emailsDatabase);
        assertEquals(expected, result);
    }
}