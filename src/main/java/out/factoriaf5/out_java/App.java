package out.factoriaf5.out_java;

import java.util.ArrayList;
import java.util.List;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        // Create new momentsList
        List<Moment> momentsList = new ArrayList<>();

        /* Test newMoment

                "Wedding day",
                "This day was just as I always wanted.",
                "Happy",
                "09/06/2016"
        */

        Diary.addMoment(momentsList);

        // Call showAllMoments
        Diary.showAllMoments(momentsList);

        // Delete 1st moment
        Diary.deleteMoment(momentsList, 1);

        Diary.showAllMoments(momentsList);
    }
}

