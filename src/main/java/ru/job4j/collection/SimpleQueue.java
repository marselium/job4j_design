package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int cntIn = 0;
    private int cntOut = 0;

    public T poll() {
        if (cntIn == 0 && cntOut == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (cntOut == 0) {
            while (cntIn > 0) {
                out.push(in.pop());
                cntIn--;
                cntOut++;
            }
        }
        cntOut--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        cntIn++;
    }
}