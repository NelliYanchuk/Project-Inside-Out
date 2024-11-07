package out.factoriaf5.out_java;

import java.util.Scanner;

public class Menu {
    private static boolean running = true;
    public static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("\n--- My Diary ---");
        System.out.println("1. Add a moment");
        System.out.println("2. View all available moments");
        System.out.println("3. Delete a moment");
        System.out.println("4. Filter moments");
        System.out.println("5. Activate Premium");
        System.out.println("6. Exit");
    }

    public static int getUserOption() {
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    public static void showFilterMenu() {
        System.out.println("\n--- Filter Moments ---");
        System.out.println("1. Filter by Emotion");
        System.out.println("2. Filter by Date");
    }

    public static int getFilterOption() {
        System.out.print("Select an option: ");
        return scanner.nextInt();
    }

    // ----------- EXIT PROGRAM -----------
    public static void exitProgram() {
        System.out.println("Until next time!!!");
        running = false;
    }

    public static boolean isRunning() {
        return running;
    }

}