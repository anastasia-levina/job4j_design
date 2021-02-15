package collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenInsertThenGet() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "first");
        assertThat(map.get(1), is("first"));
    }

    @Test
    public void whenInsertTwoElementsThenGetOne() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "first");
        map.insert(2, "second");
        map.delete(2);
        assertThat(map.get(1), is("first"));
    }

    @Test
    public void whenInsertThenIt() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "first");
        assertThat(map.iterator().next(), is("first"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.get(1);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "first");
        Iterator<String> it = map.iterator();
        map.insert(2, "second");
        it.next();
    }
}