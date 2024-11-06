package out.factoriaf5.out_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppDiary {
    private PremiumManager premiumManager;
    private List<Moment> momentsList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public AppDiary() {
        this.premiumManager = new PremiumManager();
        Diary.initialize(premiumManager);
    }

    public void start() {
        while (Diary.isRunning()) {
            Menu.showMenu();
            int option = Menu.getUserOption();
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
                    Diary.activatePremium();
                    break;
                case 6:
                    Diary.exitProgram();
                    break;
                default:
                    Menu.showMenu();
            }
        }
    }

    public static void main(String[] args) {
        AppDiary app = new AppDiary();
        app.start();
    }
}