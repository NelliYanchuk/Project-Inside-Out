package out.factoriaf5.out_java;

import java.util.Scanner;

public class AppDiary {
    private Diary diary;
    private Menu menu;
    private PremiumManager premiumManager;
    private boolean running;

    public AppDiary() {
        this.diary = new Diary();
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
            } if (option == 2) {
                viewAllMoments();
            } if (option == 3) {
                deleteMoment();
            } if (option == 4) {
                filterMoments();
            } if (option == 5) {
                activatePremium();
            } if (option == 6) {
                exitProgram();
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addMoment() {
        if (!premiumManager.isPremium() && diary.getMomentCount() >= 20) { //getMomentCount debe aparecer como metodo en la clase Diary
            System.out.println("To add more moments, acquire the premium version.");
            return;}
        System.out.println("Add moment function (pending implementation)");
    }

    private void viewAllMoments() {
        System.out.println("View all moments function (pending implementation)");
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
        System.out.println("Filter by Emotion (pending implementation)");
    }

    private void filterByDate() {
        System.out.println("Filter by Date (pending implementation)");
    }

    private void deleteMoment() {
        System.out.println("Delete a moment function (pending implementation)");
    }

    private void activatePremium() {
        premiumManager.activatePremium();
        premiumManager.showPremiumBenefits();
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
