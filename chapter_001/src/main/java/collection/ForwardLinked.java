package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (first == null) {
            first = node;
            last = node;
            return;
        }
        Node<T> tail = first;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        last = node;
    }

    public void addFirst(T value) {
        Node<T> oldNode = first;
        first = new Node<>(value, null);
        first.value = value;
        first.next = oldNode;
    }

    public T deleteFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T returnVal = first.value;
        first = first.next;
        return returnVal;
    }

    public T deleteLast() {
        T returnVal;
        if (first == null) {
            throw new NoSuchElementException();
        } else if (first == last) {
            returnVal = first.value;
            first = null;
            return returnVal;
        }
        while (first.next != last) {
            first = first.next;
        }
        returnVal = last.value;
        last = first;
        return returnVal;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void revert() {
        if (first == null || first.next == null) {
            return;
        }
        Node<T> previous = null;
        Node<T> temp = first;
        while (temp != null) {
            Node<T> nxt = temp.next;
            temp.next = previous;
            previous = temp;
            temp = nxt;
        }
        first = previous;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}