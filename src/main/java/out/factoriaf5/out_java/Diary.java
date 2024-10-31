package out.factoriaf5.out_java;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Iterator;
import java.util.Date;
import java.util.Scanner;

public class Diary {

    public static List<Moment> addMoment(List<Moment> momentsList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the title of the moment: ");
        String title = scanner.nextLine();

        System.out.print("Enter the description of the moment: ");
        String description = scanner.nextLine();

        System.out.print("Enter the emotion of the moment: ");
        String emotion = scanner.nextLine();

        System.out.print("Enter the date of the moment (dd/MM/yyyy): ");
        String dateString = scanner.nextLine();
        Date momentDate = DateFormat.strToSimpleDateFormat(dateString);

        // Assuming the ID is generated based on the size of the list or another method
        int id = momentsList.size() + 1;
        Date creationDate = new Date(); // Set creation date to now
        Date modificationDate = creationDate;

        // Create a new Moment instance with the provided values
        Moment newMoment = new Moment(id, title, description, emotion, momentDate, creationDate, modificationDate);

        // Add the new moment to the list
        momentsList.add(newMoment);

        System.out.println("Moment added successfully!");

        return momentsList;
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
