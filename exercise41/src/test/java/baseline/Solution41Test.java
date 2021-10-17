package baseline;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution41Test {

    @Test
    void sortNamesTest() {
        List<String> unsortedNames = new ArrayList<>();
        unsortedNames.add("Zarnecki, Sabrina");
        unsortedNames.add("Swift, Geoffrey");
        unsortedNames.add("Jones, Chris");

        List<String> sortedNames = new ArrayList<>();
        sortedNames.add("Jones, Chris");
        sortedNames.add("Swift, Geoffrey");
        sortedNames.add("Zarnecki, Sabrina");

        unsortedNames = Solution41.sortNames(unsortedNames);
        assertEquals(sortedNames, unsortedNames);
    }
}