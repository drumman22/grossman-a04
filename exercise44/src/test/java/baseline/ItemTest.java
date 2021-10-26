package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void nameTest() {
        String expected = "Person";
        Item actual = new Item("", 0, 0);
        actual.setName("Person");

        assertEquals(actual.getName(), expected);
    }

    @Test
    void priceTest() {
        double expected = 15.35;
        Item actual = new Item("", 0, 0);
        actual.setPrice(15.35);

        assertEquals(actual.getPrice(), expected);
    }

    @Test
    void quantityTest() {
        int expected = 10;
        Item actual = new Item("", 0, 0);
        actual.setQuantity(10);

        assertEquals(actual.getQuantity(), expected);
    }
}