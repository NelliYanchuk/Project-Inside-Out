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
    private Scanner scanner;

    @BeforeEach
    void init() {
        momentsList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    @Test
    void testAddMoment() {
        // Initialize count and simulate user inputs
        int count = Diary.getMomentCount(momentsList);
        String userInput = String.join("\n", "Wedding", "22/12/2020", "Wedding Description", "1") + "\n";
        // System.in use userInput data
        System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));

        Diary.addMoment(momentsList, scanner);

        // Assert: Verify the list size and moment details
        assertEquals(count + 1, Diary.getMomentCount(momentsList));

        // Get first element from list
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
        // Arrange: Add a Moment to the list with a specific ID
        momentsList.add(new Moment(1, "Wedding", "Wedding Description", "Joy", new Date(), new Date(), new Date()));
    
        // Simulate user input for deletion: first the ID, then confirmation with "y"
        String simulatedInput = "1\ny\n";
        Scanner testScanner = new Scanner(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
    
        // Act: Call deleteMoment with the simulated input
        Diary.deleteMoment(momentsList, testScanner);
    
        // Assert: Verify that the moment list is now empty after deletion
        assertEquals(0, Diary.getMomentCount(momentsList), "Moment list should be empty after deletion.");
    }
    

    @Test
    void testFilterByEmotion() {
        momentsList.add(new Moment(1, "Moment 1", "Description 1", "Joy", new Date(), new Date(), new Date()));
        momentsList.add(new Moment(2, "Moment 2", "Description 2", "Sadness", new Date(), new Date(), new Date()));

        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes())); // Joy
        Diary.filterByEmotion(momentsList, scanner);

        assertEquals(1, momentsList.stream().filter(m -> m.getEmotion().equals("Joy")).count());
    }

    @Test
    void testActivatePremium() {
        // Init Diary with PremiumManager
        PremiumManager premiumManager = new PremiumManager();
        Diary.initialize(premiumManager);

        Diary.activatePremium();

        // If premium mode is active
        assertTrue(premiumManager.isPremiumActive());
    }

    @Test
    void testExitProgram() {
        Diary.exitProgram();
        assertFalse(Diary.isRunning());
    }
}
