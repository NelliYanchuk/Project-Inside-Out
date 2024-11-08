package out.factoriaf5.out_java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
        Menu.scanner = new Scanner(System.in);
    }

    @Test
    void testShowMenu() {
        // Display the main menu
        Menu.showMenu();

        // Verify menu options in the output
        String output = outputStream.toString();
        assertTrue(output.contains("--- My Diary ---"));
        assertTrue(output.contains("1. Add a moment"));
        assertTrue(output.contains("2. View all available moments"));
        assertTrue(output.contains("3. Delete a moment"));
        assertTrue(output.contains("4. Filter moments"));
        assertTrue(output.contains("5. Activate Premium"));
        assertTrue(output.contains("6. Exit"));
    }

    @Test
    void testShowFilterMenu() {
        // Display the filter menu
        Menu.showFilterMenu();

        // Verify filter options in the output
        String output = outputStream.toString();
        assertTrue(output.contains("--- Filter Moments ---"));
        assertTrue(output.contains("1. Filter by Emotion"));
        assertTrue(output.contains("2. Filter by Date"));
    }

    @Test
    void testGetUserOption() {
        // Simulate user input 2
        String simulatedInput = "2\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Menu.scanner = new Scanner(System.in);

        // Get the user option
        int option = Menu.getUserOption();

        assertEquals(2, option);
    }

    @Test
    void testGetFilterOption() {
        // Simulate user input 1
        String simulatedInput = "1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Menu.scanner = new Scanner(System.in);

        // Get the filter option
        int option = Menu.getFilterOption();

        assertEquals(1, option);
    }

    @Test
    void testExitProgram() {
        Menu.exitProgram();
        assertFalse(Menu.isRunning());
    }
}
