package out.factoriaf5.out_java;

import java.util.Scanner;

public class AppDiary {
    private Diary diary;
    private boolean isPremium;
    private Scanner scanner;
    private boolean running;

    public AppDiary() {
        this.diary = new Diary(); // Create an instance of Diary
        this.isPremium = false; // Initially, the user is not premium
        this.scanner = new Scanner(System.in);
        this.running = true;
    }

    public void start() {
        while (running) {
            showMenu();
            int option = getUserOption();

            if (option == 1) {addMoment();}
            if (option == 2) {viewAllMoments();}
            if (option == 3) {deleteMoment();}
            if (option == 4) {filterMoments();}
            if (option == 5) {exitProgram();} 
            else {System.out.println("Invalid option. Please try again.");}
        }
    }

    private void showMenu() {
        System.out.println("--- My Diary ---");
        System.out.println("1. Add a moment");
        System.out.println("2. View all available moments");
        System.out.println("3. Delete a moment");
        System.out.println("4. Filter moments");
        System.out.println("5. Exit");
    }

    private int getUserOption() {
        System.out.print("Select an option: ");
        return scanner.nextInt();
    }

    private void addMoment() {
        System.out.println("Add moment function (pending implementation)");
    }

    private void viewAllMoments() {
        System.out.println("View all moments function (pending implementation)");
    }

    private void filterMoments() {
        System.out.println("Filter moments function (pending implementation)");
    }

    private void deleteMoment() {
        System.out.println("Delete a moment function (pending implementation)");
    }

    private void exitProgram() {
        System.out.println("Until next time!!!");
        running = false; 
    }

    public static void main(String[] args) {
        AppDiary app = new AppDiary();
        app.start();
    }
}
