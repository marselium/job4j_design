package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index = -1;
    private int nextIndex = -1;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return index != findEven();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index = nextIndex;
        return data[index];
    }

    public int findEven() {
        for (int i = index + 1; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                nextIndex = i;
                break;
            }
        }
        return nextIndex;
    }
}