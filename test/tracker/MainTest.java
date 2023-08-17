package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void test1() {
        // Przygotowanie danych wejściowych
        String input = "add students\nJohn Doe jd@abc.pl\nJason Bourne jb@abc.pl\nStar Trek st@abc.pl\nback\nexit\n";

        InputStream inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);

        // Przechwycenie danych wyjściowych
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));

        // Wywołanie metody main
        Main.main(new String[]{});

        // Pobranie wyników
        String output = outStream.toString();

        // Sprawdzenie wyników
        assertTrue(output.contains("Total 3 students have been added."));
        assertTrue(output.contains("Bye!"));
    }

}