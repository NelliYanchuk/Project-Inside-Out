package out.factoriaf5.out_java;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateMoment {

    public static void main(String[] args) {
        // Define test dates
        //Date dateOfMoment = new Date(); // Example: current date for the moment
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

        // Define date format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Output the created Moment details with formatted dates
        System.out.println("Moment ID: " + newMoment.getId());
        System.out.println("Title: " + newMoment.getTitle());
        System.out.println("Description: " + newMoment.getDescription());
        System.out.println("Emotion: " + newMoment.getEmotion());
        System.out.println("Date of Moment: " + sdf.format(newMoment.getDateOfMoment()));
        System.out.println("Date of Creation: " + sdf.format(newMoment.getDateOfCreation()));
        System.out.println("Date of Modification: " + sdf.format(newMoment.getDateOfModification()));
    }
}