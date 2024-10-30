package out.factoriaf5.out_java;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public final class App {
    private App() {
    }

    
    public static void main(String[] args) {
        // Example usage DateFormat:
        /* 
        Date date = DateFormat.strToSimpleDateFormat("22/12/1983");
        if (date != null) {
            System.out.println("Parsed Date: " + date);
        } else {
            System.out.println("Date parsing failed.");
        }*/

        Date dateOfMoment1 = Date ("22/12/1983");
        Date dateOfCreation1 = sdf.parse("01/01/2023");
        Date dateOfModification1 = sdf.parse("01/01/2023");

        // Create the Moments objects
        Moments moment1 = new Moments(1, "First Moment", "Description of the first moment", "Happy",
                dateOfMoment1, dateOfCreation1, dateOfModification1);

        // Initialize three moments with different data
        Moments moment1 = new Moments(1, "First Moment", "Description of the first moment", "Happy",
                SimpleDateFormat.("22/12/1983"), SimpleDateFormat("01/01/2023"), SimpleDateFormat("01/01/2023"));
}
}
