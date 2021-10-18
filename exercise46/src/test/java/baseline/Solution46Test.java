package baseline;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Solution46Test {

    @Test
    void numToStarsTest() {
        String actual = Solution46.numToStars(5);
        String expected = "*****";

        assertEquals(expected, actual);
    }
}