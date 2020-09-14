package generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private final Object[] array;
    private int allElements = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        array[allElements++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, allElements);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, allElements);
        System.arraycopy(array, index + 1, array, index, allElements - index - 1);
    }

    public T get(int index) {
        Objects.checkIndex(index, allElements);
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < allElements;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(index++);
            }
        };
    }
}