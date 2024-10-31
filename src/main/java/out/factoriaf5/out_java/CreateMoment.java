package out.factoriaf5.out_java;

import java.util.Date;
import java.util.List;

public class CreateMoment{

    public static List<Moment> main(List<Moment> momentsList) {

        // Define test dates
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
            dateOfModification
        );

        // Adding newMoment into momentsList
        momentsList.add(newMoment);
        return momentsList;
    }
}
