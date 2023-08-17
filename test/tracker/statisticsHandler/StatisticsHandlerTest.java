package tracker.statisticsHandler;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tracker.studentsHandling.StudentsHandler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsHandlerTest {
    private StudentsHandler studentsHandler = new StudentsHandler();
    private StatisticsHandler statisticsHandler = new StatisticsHandler();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    public void beforeEach() {
        initiateStudents();
        addPoints();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    public void initiateStudents() {
        String input = """
                John Doe jd@abc.pl
                Jason Bourne jb@abc.pl
                Star Trek st@abc.pl
                back
                """;
        InputStream inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        studentsHandler.addStudents(new Scanner(System.in));
        //String output = outStream.toString();
        //assertEquals("Total 3 students have been added.", output);
    }

    public void addPoints() {
        String input = """
                1 1 0 0 1
                1 1 1 0 0
                2 11 1 2 0
                2 10 1 2 0
                2 1 1 2 0
                3 1 0 0 80
                back
                """;
        InputStream inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        studentsHandler.listStudents();
        studentsHandler.addPoints(new Scanner(System.in));
        /*String expectedOutput = """
                Enter an id and points or 'back' to return:
                Points updated.
                """;
        String output = outStream.toString();
        assertEquals(expectedOutput, output);*/
    }

    @Test
    public void testStatistics() {
        String input = "java\nback\n";
        InputStream inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        statisticsHandler.showStatistics(new Scanner(System.in), studentsHandler.getStudentsDatabase());
        String expectedOutput = """
                Type the name of a course to see details or 'back' to quit:
                Most popular: Java
                Least popular: Databases
                Highest activity: Java
                Lowest activity: Spring
                Easiest course: Spring
                Hardest course: DSA
                id\tpoints
                2\t22
                1\t2
                3\t1
                """;
        //expectedOutput = expectedOutput.replace("\n", "\r\n");
        String output = outStream.toString().replace("\r","");
        assertEquals(expectedOutput, output);
        //assertTrue(output.contains(expectedOutput));
    }
}