package out.factoriaf5.out_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppDiary {
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
            Menu.showMenu();
            int option = menu.getUserOption();
            switch (option) {
                case 1:
                    Diary.addMoment(momentsList, scanner);
                    break;
                case 2:
                    Diary.showAllMoments(momentsList);
                    break;
                case 3:
                    Diary.deleteMoment(momentsList, scanner);
                    break;
                case 4:
                    Menu.showFilterMenu();
                    int filterNum = Menu.getFilterOption();
                    if (filterNum == 1) {
                        Diary.filterByEmotion(momentsList, scanner);
                    }
                    if (filterNum == 2) {
                        Diary.filterByDate(momentsList, scanner);
                    }
                    break;
                case 5:
                    activatePremium();
                    break;
                case 6:
                    exitProgram();
                    break;
                default:
                    Menu.showMenu();
            }
        }
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
}