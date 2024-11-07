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
        System.out.print("\nTo Add new moment please enter it's title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the date of the moment (dd/MM/yyyy): ");
        String dateString = scanner.nextLine();
        
        System.out.print("Enter the description of the moment: ");
        String description = scanner.nextLine();
        
        System.out.print("Please select the emotion from the following list: ");
        for (Emotion emotion : Emotion.values()) {
            System.out.print("\n" + emotion.getNumber() + ". " + emotion.getName() + " ");
        }
        System.out.print("\n\nEnter emotion number: ");
        int emotionNum = scanner.nextInt();
        scanner.nextLine();

        String emotionName = Emotion.getNameByNumber(emotionNum);
        if (emotionName == null) {
            System.out.println("Invalid emotion number selected.");
            return;
        }

        Date momentDate = DateFormat.strToSimpleDateFormat(dateString);

        int addId = momentsList.isEmpty() ? 1 : momentsList.get(momentsList.size() - 1).getId() + 1;

        Moment newMoment = new Moment(addId, title, description, emotionName, momentDate, new Date(), new Date());
        momentsList.add(newMoment);

        System.out.println("\nNew '" + title + "' life moment is added correctly.");

        int totalMoments = getMomentCount(momentsList);
        System.out.println("Total moments now: " + totalMoments);
    }

    // ----------- GET THE AMOUNT of moments -----------
    public static int getMomentCount(List<Moment> momentsList) {
        return momentsList.size();
    }

    // ----------- SHOW ALL Moments -----------
    public static void showAllMoments(List<Moment> momentsList) {
        if (momentsList.isEmpty()) {
            System.out.println("\nThere are no moments available.");
            return;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            int momentQty = momentsList.size();

            System.out.println("\n");
            System.out.println("\n--- Available moments: " + momentQty + " ---\n");
            for (Moment moment : momentsList) {
                System.out.println("\n");
                System.out.println("Moment ID: " + moment.getId());
                System.out.println("It happened on: " + sdf.format(moment.getDateOfMoment()));
                System.out.println("Title: " + moment.getTitle());
                System.out.println("Description: " + moment.getDescription());
                System.out.println("Emotion: " + moment.getEmotion());
                System.out.println("Date of Creation: " + sdf.format(moment.getDateOfCreation()));
                System.out.println("Date of Modification: " + sdf.format(moment.getDateOfModification()));
            }
        }
    }

    // ----------- DELETE Moment -----------
    public static void deleteMoment(List<Moment> momentsList, Scanner scanner) {
        System.out.print("\nTo delete enter the id of the moment: ");
        int deleteId = Integer.valueOf(scanner.nextLine());

        Iterator<Moment> iterator = momentsList.iterator();
        while (iterator.hasNext()) {
            Moment moment = iterator.next();
            if (moment.getId() == deleteId) {
                String deleteTitle = moment.getTitle();
                System.out.print("Please confirm deleting '" + deleteTitle + "' moment (y): ");
                String deleteFlag = scanner.nextLine();
                if (deleteFlag.equalsIgnoreCase("y")) {
                    iterator.remove();
                    System.out.println("\n'" + deleteTitle + "' Lived Moment with ID #" + deleteId + " Correctly Deleted.");
                } else {
                    System.out.println("\nDeclined delete '" + deleteTitle + "' moment with ID #" + deleteId);
                }
                return;
            }
        }
        System.out.println("\nMoment with ID #" + deleteId + " is not found.");
    }

    // ----------- FILTER BY EMOTION -----------
    public static void filterByEmotion(List<Moment> momentsList, Scanner scanner) {
        List<Moment> filterByEmotionList = new ArrayList<>();

        System.out.print("\nPlease select the emotion from the list below: ");
        for (Emotion emotion : Emotion.values()) {
            System.out.print("\n" + emotion.getNumber() + ". " + emotion.getName() + " ");
        }
        System.out.print("\n\nAnd enter it's number:");
        int emotionNum = scanner.nextInt();
        scanner.nextLine();
        String emotionName = Emotion.getNameByNumber(emotionNum);

        if (emotionName != null) {
            for (Moment moment : momentsList) {
                if (moment.getEmotion().equalsIgnoreCase(emotionName)) {
                    filterByEmotionList.add(moment);
                }
            }

            showAllMoments(filterByEmotionList);
        }
    }

    // ----------- FILTER BY DATE -----------
    public static void filterByDate(List<Moment> momentsList, Scanner scanner) {

        List<Moment> filterByDateList = new ArrayList<>();

        System.out.print("\nEnter the date of the moment to filter by (dd/MM/yyyy): ");
        String dateString = scanner.nextLine();

        Date filterDate = DateFormat.strToSimpleDateFormat(dateString);

        if (filterDate == null) {
            System.out.println("Invalid date format.");
            return;
        }

        for (Moment moment : momentsList) {
            if (moment.getDateOfMoment().equals(filterDate)) {
                filterByDateList.add(moment);
            }
        }

        showAllMoments(filterByDateList);
    }




}