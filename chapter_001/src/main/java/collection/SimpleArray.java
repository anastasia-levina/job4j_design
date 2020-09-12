package collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container;
    private int allElements = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.container = new Object[1];
    }

    public T get(int index) {
        Objects.checkIndex(index, allElements);
        return (T) container[index];
    }

    public void add(T model) {
        if (allElements < container.length) {
            container[allElements++] = model;
        } else {
            container = Arrays.copyOf(container, container.length + 1);
        }
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int index = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
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
