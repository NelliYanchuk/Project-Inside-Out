package out.factoriaf5.out_java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class MomentTest {

    @Test
    void testConstructorInit() {
        Date dateOfMoment = new Date();
        Date dateOfCreation = new Date();
        Date dateOfModification = new Date();

        Moment moment = new Moment(1, "Title", "Description", "Joy", dateOfMoment, dateOfCreation, dateOfModification);

        assertEquals(1, moment.getId());
        assertEquals("Title", moment.getTitle());
        assertEquals("Description", moment.getDescription());
        assertEquals("Joy", moment.getEmotion());
        assertEquals(dateOfMoment, moment.getDateOfMoment());
        assertEquals(dateOfCreation, moment.getDateOfCreation());
        assertEquals(dateOfModification, moment.getDateOfModification());
    }

    @Test
    void testGetters() {
        Date dateOfMoment = new Date();
        Date dateOfCreation = new Date();
        Date dateOfModification = new Date();

        Moment moment = new Moment(2, "Test Title", "Test Description", "Sad", dateOfMoment, dateOfCreation,
                dateOfModification);

        assertEquals(2, moment.getId());
        assertEquals("Test Title", moment.getTitle());
        assertEquals("Test Description", moment.getDescription());
        assertEquals("Sad", moment.getEmotion());
        assertEquals(dateOfMoment, moment.getDateOfMoment());
        assertEquals(dateOfCreation, moment.getDateOfCreation());
        assertEquals(dateOfModification, moment.getDateOfModification());
    }

    @Test
    void testNullValues() {
        Date dateOfMoment = new Date();
        Date dateOfCreation = new Date();
        Date dateOfModification = new Date();

        Moment moment = new Moment(3, null, null, null, dateOfMoment, dateOfCreation, dateOfModification);

        assertNull(moment.getTitle());
        assertNull(moment.getDescription());
        assertNull(moment.getEmotion());
        assertEquals(dateOfMoment, moment.getDateOfMoment());
    }

}