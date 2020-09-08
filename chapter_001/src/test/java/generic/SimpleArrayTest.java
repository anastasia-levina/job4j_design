package generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddAndGetOneObject() {
        Object model = new Object();
        SimpleArray<Object> array = new SimpleArray<Object>(5);
        array.add(model);
        Object rsl = array.get(0);
        assertThat(rsl, is(model));
    }

    @Test
    public void whenAddAndGetTwoObject() {
        Object model = new Object();
        Object model2 = new Object();
        SimpleArray<Object> array = new SimpleArray<Object>(2);
        array.add(model);
        array.add(model2);
        Object rsl = array.get(0);
        Object rsl2 = array.get(1);
        assertThat(rsl, is(model));
        assertThat(rsl2, is(model2));
    }

    @Test
    public void whenSet() {
        Object model = new Object();
        Object model2 = new Object();
        SimpleArray<Object> array = new SimpleArray<Object>(6);
        array.add(model);
        array.set(0, model2);
        Object rsl = array.get(0);
        assertThat(rsl, is(model2));
    }

    @Test
    public void whenRemoveOneObject() {
        Object model = new Object();
        Object model2 = new Object();
        Object model3 = new Object();
        Object model4 = new Object();
        Object model5 = new Object();
        SimpleArray<Object> array = new SimpleArray<Object>(5);
        array.add(model);
        array.add(model2);
        array.add(model3);
        array.add(model4);
        array.add(model5);
        array.remove(0);
        Object rsl = array.get(0);
        assertThat(rsl, is(model2));
    }

    @Test
    public void whenRemoveTwoObject() {
        Object model = new Object();
        Object model2 = new Object();
        Object model3 = new Object();
        Object model4 = new Object();
        Object model5 = new Object();
        SimpleArray<Object> array = new SimpleArray<Object>(5);
        array.add(model);
        array.add(model2);
        array.add(model3);
        array.add(model4);
        array.add(model5);
        array.remove(0);
        array.remove(1);
        Object rsl = array.get(0);
        Object rsl2 = array.get(1);
        assertThat(rsl, is(model2));
        assertThat(rsl2, is(model4));
    }
}