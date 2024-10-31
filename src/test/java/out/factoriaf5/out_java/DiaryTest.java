/*package out.factoriaf5.out_java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    private Diary diary;
    private Moment moment1, moment2, moment3;

    @Test
    public void testShowAllMoments() {
        diary.addMoment(moment1);
        diary.addMoment(moment2);
        diary.addMoment(moment3);

        List<Moment> allMoments = diary.getMoments();
        assertEquals(3, allMoments.size());
        assertTrue(allMoments.contains(moment1));
        assertTrue(allMoments.contains(moment2));
        assertTrue(allMoments.contains(moment3));
    }

    @Test
    public void testFilterByEmotion() {
        diary.addMoment(moment1);
        diary.addMoment(moment2);
        diary.addMoment(moment3);

        List<Moment> happinessMoments = diary.filterByEmotion("Happiness");
        assertEquals(2, happinessMoments.size());
        assertTrue(happinessMoments.contains(moment1));
        assertTrue(happinessMoments.contains(moment3));

        List<Moment> sadnessMoments = diary.filterByEmotion("Sadness");
        assertEquals(1, sadnessMoments.size());
        assertTrue(sadnessMoments.contains(moment2));
    }

}


*/