package out.factoriaf5.out_java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    private List<Moment> momentsList;

    @BeforeEach
    void init() {
        momentsList = new ArrayList<>();
    }

    @Test
    void testAddMoment() {
        // Init count and simulate user input
        int initialCount = Diary.getMomentCount(momentsList);
        String userInput = String.join("\n", "Wedding", "22/12/2020", "Wedding Description", "1") + "\n";
        // Read from userInput
        Scanner testScanner = new Scanner(new java.io.ByteArrayInputStream(userInput.getBytes()));

        Diary.addMoment(momentsList, testScanner);

        // If moment list size increased by one
        assertEquals(initialCount + 1, Diary.getMomentCount(momentsList));

        // Details of the added moment
        Moment addedMoment = momentsList.get(0);
        assertEquals("Wedding", addedMoment.getTitle());
        assertEquals("Wedding Description", addedMoment.getDescription());
        assertEquals("Joy", addedMoment.getEmotion());
    }

    @Test
    void testGetMomentCount() {
        assertEquals(0, Diary.getMomentCount(momentsList));
        momentsList.add(new Moment(1, "Wedding", "Wedding Description", "Joy", new Date(), new Date(), new Date()));
        assertEquals(1, Diary.getMomentCount(momentsList));
    }

    @Test
    void testDeleteMoment() {
        momentsList.add(new Moment(1, "Wedding", "Wedding Description", "Joy", new Date(), new Date(), new Date()));

        // Simulate user input
        String simulatedInput = "1\ny\n";
        Scanner testScanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        Diary.deleteMoment(momentsList, testScanner);

        // If moment list is empty after delete
        assertEquals(0, Diary.getMomentCount(momentsList));
    }

    @Test
    void testFilterByEmotion() {
        // Add two moments with different emotions
        momentsList.add(new Moment(1, "Moment 1", "Description 1", "Joy", new Date(), new Date(), new Date()));
        momentsList.add(new Moment(2, "Moment 2", "Description 2", "Sadness", new Date(), new Date(), new Date()));

        // User input for Joy
        String simulatedInput = "1\n";
        Scanner testScanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        Diary.filterByEmotion(momentsList, testScanner);

        // If only Joy moment is included
        long joyCount = momentsList.stream().filter(m -> m.getEmotion().equals("Joy")).count();
        assertEquals(1, joyCount);
    }

    @Test
    void testExitProgram() {
        Menu.exitProgram();
        assertFalse(Menu.isRunning());
    }
}
