package collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAdd2IdenticalObjects() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("first");
        assertEquals(1, array.size());
    }

    @Test
    public void whenAdd4DifferentObjects() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("fourth");
        assertEquals(4, array.size());
    }

    @Test
    public void whenAdd2IdenticalAndOtherObjects() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("first");
        assertEquals(3, array.size());
    }
}