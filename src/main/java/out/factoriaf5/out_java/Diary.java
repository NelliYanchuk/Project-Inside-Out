package out.factoriaf5.out_java;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Diary {

    public static List<Moment> addMoment(List<Moment> momentsList, Moment newMoment) {

        // Adding newMoment into momentsList
        momentsList.add(newMoment);
        return momentsList;
    }
   public static List<Moment> filterByEmotion(List<Moment> momentsList, String emotion) {
    List<Moment> result = new ArrayList<>();
    for (Moment moment : momentsList) {
        if (moment.getEmotion().equalsIgnoreCase(emotion)) {
            result.add(moment);
        }
    }
    return result;
}
        

    public static void deleteMoment(List<Moment> momentsList, int id) {
        Iterator<Moment> iterator = momentsList.iterator();
        while (iterator.hasNext()) {
            Moment moment = iterator.next();
            if (moment.getId() == id) {
                iterator.remove();
                System.out.println("\nMoment with ID " + id + " has been deleted.");
                return;
            }
        }
        System.out.println("\nMoment with ID " + id + " not found.");
    }

    public static void showAllMoments(List<Moment> momentsList) {
        if (momentsList.isEmpty()) {
            System.out.println("There are no moments available.");
        } else {
            // Define date format for formatting dates
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            int momentQty = momentsList.size();

            System.out.println("\n");
            System.out.println("\n--- I have " + momentQty + " moments ---\n");
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



