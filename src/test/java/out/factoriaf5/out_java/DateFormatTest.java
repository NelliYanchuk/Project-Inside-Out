package out.factoriaf5.out_java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatTest {

    @Test
    void testIncorrectDateFormat() {
        assertNull(DateFormat.strToSimpleDateFormat("2021-08-15"));
    }

    @Test
    void testEmptyString() {
        assertNull(DateFormat.strToSimpleDateFormat(""));
    }

}
