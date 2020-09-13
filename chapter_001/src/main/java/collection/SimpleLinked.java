package collection;

import java.util.*;

public class SimpleLinked<E> implements Iterable<E> {

    private Node<E> node;
    private int size = 0;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                break;
            }
            current = current.next;
        }
        return current.item;
    }

    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private int index = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(index++);
            }
        };
    }
}