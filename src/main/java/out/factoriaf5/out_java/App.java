package out.factoriaf5.out_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        // Create new momentsList
        List<Moment> momentsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Adding a moment
        Diary.addMoment(momentsList, scanner);

        // Call showAllMoments
        Diary.showAllMoments(momentsList);

        // Delete 1st moment
       // Diary.deleteMoment(momentsList, scanner);

       // Diary.showAllMoments(momentsList);

        // to filtr
        Diary.filterByEmotion(momentsList, scanner);
        // Close the Scanner after all operations
        scanner.close();
    }
}