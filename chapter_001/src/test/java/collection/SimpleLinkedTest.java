package collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLinkedTest {

    @Test
    public void whenAddThenGet() {
        SimpleLinked<String> link = new SimpleLinked<>();
        link.add("first");
        String rsl = link.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAdd3ThenGet() {
        SimpleLinked<String> link = new SimpleLinked<>();
        link.add("first");
        link.add("second");
        link.add("third");
        String rsl = link.get(1);
        assertThat(rsl, is("second"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleLinked<String> link = new SimpleLinked<>();
        link.add("first");
        String rsl = link.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleLinked<String> link = new SimpleLinked<>();
        link.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleLinked<String> link = new SimpleLinked<>();
        link.add("first");
        link.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleLinked<String> link = new SimpleLinked<>();
        link.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinked<String> link = new SimpleLinked<>();
        link.add("first");
        Iterator<String> it = link.iterator();
        link.add("second");
        it.next();
    }
}