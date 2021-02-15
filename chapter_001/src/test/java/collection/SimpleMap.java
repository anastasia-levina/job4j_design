package collection;

import java.util.*;

public class SimpleMap<K, V> implements Iterable<V> {

    private int capacity = 16;
    static final float LOAD_FACTOR = 0.75f;
    private int size = 0;
    private int modCount = 0;
    private Node<K, V>[] table = new Node[capacity];

    public boolean insert(K key, V value) {
        if (table[hash(key)] == null) {
            if (size >= capacity * LOAD_FACTOR) {
                expand();
            }
            table[hash(key)] = new Node<>(key, value);
            size++;
            modCount++;
        }
        return false;
    }

    public V get(K key) {
        if (table[hash(key)] != null && table[hash(key)].getKey().equals(key)) {
            return table[hash(key)].getValue();
        }
        throw new NoSuchElementException();
    }

    public boolean delete(K key) {
        if (table[hash(key)] != null && table[hash(key)].getKey().equals(key)) {
            table[hash(key)] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    final int hash(K key) {
        return key.hashCode() % capacity;
    }

    void expand() {
        capacity *= 2;
        Node<K, V>[] newTable = new Node[capacity];
        for (Node c : table) {
            newTable[hash((K) c.getKey())] = c;
        }
        table = newTable;
    }

    static class Node<K, V> {
        final K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }
    }

    @Override
    public Iterator<V> iterator() {

        return new Iterator<V>() {
            private int index = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < capacity;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[index] == null) {
                    index++;
                }
                return table[index++].getValue();
            }
        };
    }
}