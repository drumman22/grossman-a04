package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution42Test {

    @Test
    void generatePersonList() {
        // Test
        List<String> paramTest = new ArrayList<>();
        paramTest.add("Grossman,Jason,1000");
        paramTest.add("Smith,Henry,500");
        paramTest.add("Windrunner,Tanner,5000");
        List<Person> actualList = Solution42.generatePersonList(paramTest);

        // Expected
        List<Person> expectedList = new ArrayList<>();
        expectedList.add(new Person("Jason", "Grossman", 1000));
        expectedList.add(new Person("Henry", "Smith", 500));
        expectedList.add(new Person("Tanner", "Windrunner", 5000));

        // Test if both person lists have same values
        assertEquals(expectedList.get(0).first, actualList.get(0).first);
        assertEquals(expectedList.get(0).last, actualList.get(0).last);
        assertEquals(expectedList.get(0).salary, actualList.get(0).salary);

        assertEquals(expectedList.get(1).first, actualList.get(1).first);
        assertEquals(expectedList.get(1).last, actualList.get(1).last);
        assertEquals(expectedList.get(1).salary, actualList.get(1).salary);

        assertEquals(expectedList.get(2).first, actualList.get(2).first);
        assertEquals(expectedList.get(2).last, actualList.get(2).last);
        assertEquals(expectedList.get(2).salary, actualList.get(2).salary);
    }
}