package it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator {
    private final int[] numbers;
    private int pointer = 0;

    public EvenIt(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        if (pointer >= numbers.length) {
            return false;
        }
        if (numbers[pointer] % 2 != 0) {
            pointer++;
        }
        return pointer < numbers.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[pointer++];
    }

    @Override
    public void remove() {
    }
}