package out.factoriaf5.out_java;

import java.util.Date;

public class Moment {
    private int id;
    private String title;
    private String description;
    private String emotion;
    private Date dateOfMoment;
    private Date dateOfCreation;
    private Date dateOfModification;

    // Constructor
    public Moment(int id, String title, String description, String emotion,
            Date dateOfMoment, Date dateOfCreation, Date dateOfModification) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.dateOfMoment = dateOfMoment;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEmotion() {
        return emotion;
    }

    public Date getDateOfMoment() {
        return dateOfMoment;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public Date getDateOfModification() {
        return dateOfModification;
    }

}