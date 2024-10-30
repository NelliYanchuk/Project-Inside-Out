package out.factoriaf5.out_java;

import java.text.SimpleDateFormat;

public class Moments {
  private int id;
    private String title;
    private String description;
    private String emotion;
    private SimpleDateFormat dateOfMoment;
    private SimpleDateFormat dateOfCreation;
    private SimpleDateFormat dateOfModification;

    // Constructor
    public Moments(int id, String title, String description, String emotion,
            SimpleDateFormat dateOfMoment, SimpleDateFormat dateOfCreation, SimpleDateFormat dateOfModification) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.dateOfMoment = dateOfMoment;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }
}
