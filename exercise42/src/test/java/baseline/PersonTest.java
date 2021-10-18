package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPersonCreate() {
        Person person = new Person("Jason", "Grossman", 1000);

        assertEquals("Jason", person.getFirst());
        assertEquals("Grossman", person.getLast());
        assertEquals(1000, person.getSalary());
    }

}