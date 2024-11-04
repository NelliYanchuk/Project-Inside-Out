package out.factoriaf5.out_java;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Diary {

    // ----------- ADD Momemt -----------
    public static void addMoment(List<Moment> momentsList, Scanner scanner) {
        // User input data 
        System.out.print("\nTo Add new moment please enter it's title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter the description of the moment: ");
        String description = scanner.nextLine();
        
        System.out.print("Enter the emotion of the moment: ");
        String emotion = scanner.nextLine();
        
        System.out.print("Enter the date of the moment (dd/MM/yyyy): ");
        String dateString = scanner.nextLine();

        // ----- Test data -----
        /* String title = "Wedding day";
        String description = "This day was as I always dreamed!";
        String emotion = "Joy";
        String dateString = "09/06/2016";

        String title2 = "30th Birthday";
        String description2 = "So many friends has come!";
        String emotion2 = "Joy";
        String dateString2 = "09/08/2018";

        String title3 = "Funeral day";
        String description3 = "I still love you";
        String emotion3 = "Sadness";
        String dateString3 = "09/06/2020"; */

        Date momentDate = DateFormat.strToSimpleDateFormat(dateString);

        // Add id automatically. Check id of the last element of the list and add 1
        int addId = momentsList.isEmpty() ? 1 : momentsList.get(momentsList.size() - 1).getId() + 1;

        // Create a new Moment instance. Set creationDate and modificationDate to
        // current date
        Moment newMoment = new Moment(addId, title, description, emotion, momentDate, new Date(), new Date());

        // Add the new moment to the list
        momentsList.add(newMoment);

        System.out.println("\nNew '" + title + "' moment added successfully!");

        int totalMoments = getMomentCount(momentsList);
        System.out.println("Total moments now: " + totalMoments);

        // ----- Test data. -----
        // Add 2d moment
        /* Date momentDate2 = DateFormat.strToSimpleDateFormat(dateString2);
        int addId2 = momentsList.isEmpty() ? 1 : momentsList.get(momentsList.size() - 1).getId() + 1;
        Moment newMoment2 = new Moment(addId2, title2, description2, emotion2,
                momentDate2, new Date(), new Date());
        momentsList.add(newMoment2);
        // Add 3d moment
        Date momentDate3 = DateFormat.strToSimpleDateFormat(dateString3);
        int addId3 = momentsList.isEmpty() ? 1 : momentsList.get(momentsList.size() - 1).getId() + 1;
        Moment newMoment3 = new Moment(addId3, title3, description3, emotion3,
                momentDate3, new Date(), new Date());
        momentsList.add(newMoment3); */
    }

    // ----------- GET THE AMOUNT of moments -----------
    public static int getMomentCount(List<Moment> momentsList) {
        return momentsList.size();
    }

    // ----------- FILTER BY EMOTION -----------
    public static void filterByEmotion(List<Moment> momentsList, Scanner scanner) {
        // New list for moments filtered by emotion
        List<Moment> filterByEmotionList = new ArrayList<>();

        System.out.print("\nPlease select the emotion from the list below: ");
        // Output all values from enum Emotion
        for (Emotion emotion : Emotion.values()) {
            System.out.print("\n" + emotion.getNumber() + ". " + emotion.getName() + " ");
        }
        System.out.print("\n\nAnd enter it's number:");
        // Read the answer into variable emotion num
        int emotionNum = scanner.nextInt();
        // Find emotion by it's number
        String emotionName = Emotion.getNameByNumber(emotionNum);

        // If there is a correct emotion
        if (emotionName != null) {
            // Check the existed list
            for (Moment moment : momentsList) {
                // If emotion is found - add whole moment to filterByEmotionList
                if (moment.getEmotion().equalsIgnoreCase(emotionName)) {
                    filterByEmotionList.add(moment);
                }
            }
            // Show all moments filtered by emotion
            showAllMoments(filterByEmotionList);
        }
    }

    // ----------- FILTER BY DATE -----------
    public static void filterByDate(List<Moment> momentsList, Scanner scanner) {
        // New list for moments filtered by date
        List<Moment> filterByDateList = new ArrayList<>();

        System.out.print("\nEnter the date of the moment to filter by (dd/MM/yyyy): ");
        String dateString = scanner.nextLine();

        // Convert the user input string into a Date object
        Date filterDate = DateFormat.strToSimpleDateFormat(dateString);

        // Check if the date is valid
        if (filterDate == null) {
            System.out.println("Invalid date format.");
            return;
        }

        // Filter moments by the specified date
        for (Moment moment : momentsList) {
            if (moment.getDateOfMoment().equals(filterDate)) {
                filterByDateList.add(moment);
            }
        }

        // Show all moments filtered by date
        showAllMoments(filterByDateList);
    }

    // ----------- DELETE Moment -----------
    public static void deleteMoment(List<Moment> momentsList, Scanner scanner) {
        System.out.print("\nTo delete enter the id of the moment: ");
        int deleteId = Integer.valueOf(scanner.nextLine());

        // Iterator by Moments into momentsList
        Iterator<Moment> iterator = momentsList.iterator();
        while (iterator.hasNext()) {
            Moment moment = iterator.next();
            if (moment.getId() == deleteId) {
                String deleteTitle = moment.getTitle();
                // Confirmation of deleting
                System.out.print("Please confirm deleting '" + deleteTitle + "' moment (y): ");
                String deleteFlag = scanner.nextLine();
                if (deleteFlag.equalsIgnoreCase("y")) {
                    iterator.remove();
                    System.out.println("\n'" + deleteTitle + "' moment with ID #" + deleteId + " has been deleted.");
                } else {
                    System.out.println("\nDeclined delete '" + deleteTitle + "' moment with ID #" + deleteId);
                }
                return;
            }
        }
        System.out.println("\nMoment with ID #" + deleteId + " is not found.");
    }

    // ----------- SHOW ALL Moments -----------
    public static void showAllMoments(List<Moment> momentsList) {
        if (momentsList.isEmpty()) {
            System.out.println("\nThere are no moments available.");
            return;
        } else {
            // Define date format for formatting dates
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            int momentQty = momentsList.size(); // Get the count of moments

            System.out.println("\n");
            System.out.println("\n--- Available moments: " + momentQty + " ---\n");
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
