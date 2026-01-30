package at.technikum.slm.tictactoe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main_acceptsValidInput() {
        // sind aktuell Tastatur/Konsole
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            String input = "0\n1\n";
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))); // “Fake Tastatur”

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8)); // “Fake Konsole”

            Main.main(new String[0]);

            String printed = out.toString(StandardCharsets.UTF_8);
            assertTrue(printed.contains("Row (y)"));
            assertTrue(printed.contains("Column (x)"));
        } finally {
            //Zurücksetzen auf Tastatur / Konsole - sonst könnte ich später Probleme bekommen
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    void main_testsAllErrorMessages() {
        // sind aktuell Tastatur/Konsole
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            String input = "-1\n1.2\n2\n89\na\n0\n";
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))); // “Fake Tastatur”

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8)); // “Fake Konsole”

            Main.main(new String[0]);

            String printed = out.toString(StandardCharsets.UTF_8);
            assertTrue(printed.contains("Fehler: Row"));
            assertTrue(printed.contains("Fehler: Column"));
            assertTrue(printed.contains("Fehler: Bitte"));

        } finally {
            //Zurücksetzen auf Tastatur / Konsole - sonst könnte ich später Probleme bekommen
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }


}