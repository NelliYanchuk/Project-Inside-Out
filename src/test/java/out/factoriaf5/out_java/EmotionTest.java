package out.factoriaf5.out_java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmotionTest {

    @Test
    void testGetName() {
        assertEquals("Joy", Emotion.JOY.getName());
        assertEquals("Sadness", Emotion.SAD.getName());
        assertEquals("Anger", Emotion.ANG.getName());
    }

    @Test
    void testGetNumber() {
        assertEquals(1, Emotion.JOY.getNumber());
        assertEquals(3, Emotion.ANG.getNumber());
        assertEquals(4, Emotion.DIS.getNumber());
    }

    @Test
    void testGetNameByNumber() {
        assertEquals("Joy", Emotion.getNameByNumber(1));
        assertEquals("Nostalgia", Emotion.getNameByNumber(10));
        assertNull(Emotion.getNameByNumber(11)); // Test for a non-existing number
    }

    @Test
    void testValues() {
        Emotion[] emotions = Emotion.values();
        assertEquals(10, emotions.length);
        assertEquals(Emotion.NOS, emotions[9]);
    }
}
