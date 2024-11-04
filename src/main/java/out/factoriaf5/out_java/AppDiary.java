/* package out.factoriaf5.out_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppDiary {
    private Diary diary = new Diary();
    private Menu menu;
    private PremiumManager premiumManager;
    private boolean running;
    private List<Moment> momentsList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public AppDiary() {
        this.menu = new Menu();
        this.premiumManager = new PremiumManager();
        this.running = true;
    }

    public void start() {
        while (running) {
            menu.showMenu();
            int option = menu.getUserOption();
            if (option == 1) {
                addMoment(); 
                return;
            } if (option == 2) {
                viewAllMoments();
                return;
            } if (option == 3) {
                deleteMoment();
                return;
            } if (option == 4) {
                filterMoments();
                return;
            } if (option == 5) {
                activatePremium();
                return;
            } if (option == 6) {
                exitProgram();
                return;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addMoment() {
        if (!premiumManager.isUserPremium() && Diary.getMomentCount(momentsList) >= 20) { //getMomentCount debe aparecer como metodo en la clase Diary
            System.out.println("To add more moments, acquire the premium version.");
            return;}
        Diary.addMoment(momentsList, scanner);
    }

    private void viewAllMoments() {
        Diary.showAllMoments(momentsList);
    }

    private void filterMoments() {
        menu.showFilterMenu();
        int filterOption = menu.getFilterOption();

        if (filterOption == 1) {
            filterByEmotion();
        } if (filterOption == 2) {
            filterByDate();
        } else {
            System.out.println("Invalid filter option. Please try again.");}
    }

    private void filterByEmotion() {
        System.out.print("Enter the emotion to filter by: ");
        String emotion = scanner.nextLine();
        List<Moment> filteredMoments = Diary.filterByEmotion(momentsList, emotion);

        if (filteredMoments.isEmpty()) {
            System.out.println("No moments found with emotion: " + emotion);
        } else {
            Diary.showAllMoments(filteredMoments);
        }
    }

    private void filterByDate() {
        System.out.println("Filter by Date (pending implementation)");
    }

    private void deleteMoment() {
        Diary.deleteMoment(momentsList, scanner);
    }

    private void activatePremium() {
        premiumManager.activatePremium();
        premiumManager.displayPremiumBenefits();
    }

    private void exitProgram() {
        System.out.println("Until next time!!!");
        running = false;
    }

    public static void main(String[] args) {
        AppDiary app = new AppDiary();
        app.start();
    }
} */