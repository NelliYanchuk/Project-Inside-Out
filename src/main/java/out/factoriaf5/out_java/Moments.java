package out.factoriaf5.out_java;

import java.util.Date;
import java.util.List;

public class Moments {
    private int id;
    private String title;
    private String description;
    private String emotion;
    private Date dateOfMoment;
    private Date dateOfCreation;
    private Date dateOfModification;

    // Constructor
    public Moments(int id, String title, String description, String emotion,
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

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public void setDateOfMoment(Date dateOfMoment) {
        this.dateOfMoment = dateOfMoment;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setDateOfModification(Date dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    public void setAll(int id,
            String title,
            String description,
            String emotion,
            Date dateOfMoment,
            Date dateOfCreation,
            Date dateOfModification) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.dateOfMoment = dateOfMoment;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }

    // Method to get id by title from a list of Moments
    public static Integer getIdByTitle(List<Moments> momentsList, String title) {
        for (Moments moment : momentsList) {
            if (moment.getTitle().equalsIgnoreCase(title)) {
                return moment.getId();
            }
        }
        return null; // if no moment is found
    }

}
