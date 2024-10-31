package out.factoriaf5.out_java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        // Create new momentsList
        List<Moment> momentsList = new ArrayList<>();

        // Define test newMoment
        Date dateOfMoment = DateFormat.strToSimpleDateFormat("22/12/2000");
        Date dateOfCreation = DateFormat.strToSimpleDateFormat("23/12/2000");
        Date dateOfModification = DateFormat.strToSimpleDateFormat("01/02/2003");

        // Create a new Moment instance
        Moment newMoment = new Moment(
                1,
                "My First Moment",
                "This is a description of my first moment.",
                "Happy",
                dateOfMoment,
                dateOfCreation,
                dateOfModification);
        
        // Create a new Moment instance
        Moment newMoment2 = new Moment(
                2,
                "My Second Moment",
                "This is a description of my second moment.",
                "Sad",
                dateOfMoment,
                dateOfCreation,
                dateOfModification);
        
        // Call the main method of CreateMoment
        Diary.addMoment(momentsList, newMoment);
        Diary.addMoment(momentsList, newMoment2);

        //Call showAllMoments
        Diary.showAllMoments(momentsList);
    }
}

