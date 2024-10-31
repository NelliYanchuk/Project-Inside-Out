package out.factoriaf5.out_java;

import java.text.SimpleDateFormat;
import java.util.List;

public class Diary {

    public static List<Moment> createMoment(List<Moment> momentsList, Moment newMoment) {

        // Adding newMoment into momentsList
        momentsList.add(newMoment);
        return momentsList;
    }

    public static void showAllMoments(List<Moment> momentsList) {
        if (momentsList.isEmpty()) {
            System.out.println("There are no moments available.");
        } else {
            // Define date format for formatting dates
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("\n");
            System.out.println("\n--- Your Moments ---\n");
            for (Moment moment : momentsList) {
                System.out.println("\n");
                System.out.println("Moment ID: " + moment.getId());
                System.out.println("Title: " + moment.getTitle());
                System.out.println("Description: " + moment.getDescription());
                System.out.println("Emotion: " + moment.getEmotion());
                System.out.println("Date of Moment: " + sdf.format(moment.getDateOfMoment()));
                System.out.println("Date of Creation: " + sdf.format(moment.getDateOfCreation()));
                System.out.println("Date of Modification: " + sdf.format(moment.getDateOfModification()));
            }
        }
    }
}

/*
 * public List<Moment> filterByEmotion(String emocion) {
 * List<Moment> result = new ArrayList<>();
 * for (Moment moment : moment) {
 * if (moment.getEmocion().equalsIgnoreCase(emocion)) {
 * result.add(moment);
 * }
 * }
 * return result;
 * }
 */
