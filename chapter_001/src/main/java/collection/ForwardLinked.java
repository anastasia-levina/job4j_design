package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> last;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            last = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        last = node;
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        } else {
            throw new NoSuchElementException();
        }
    }

    public T deleteLast() {
        T returnVal;
        if (head == null) {
            throw new NoSuchElementException();
        } else if (head == last) {
            returnVal = head.value;
            head = null;
            return returnVal;
        }
        while (head.next != last) {
            head = head.next;
        }
        returnVal = last.value;
        last = head;
        return returnVal;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

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