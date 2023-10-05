package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> end = head;
        while (end.next != null) {
            end = end.next;
        }
        end.next = node;
        modCount++;
        size++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> foundItem = head;
        for (int i = 0; i < index; i++) {
            foundItem = foundItem.next;
        }
        return foundItem.item;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> old = head;
        T oldVal = head.item;
        head = head.next;
        old.next = null;
        old.item = null;
        modCount++;
        size++;
        return oldVal;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final int expModCount = modCount;
            private Node<T> idx = head;

            @Override
            public boolean hasNext() {
                if (expModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return idx != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = idx.item;
                idx = idx.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}