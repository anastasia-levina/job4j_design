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
        while (numbers[pointer] % 2 != 0) {
            pointer++;
            if (pointer >= numbers.length) {
                pointer = numbers.length - 1;
                return false;
            }
        }
        return true;
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