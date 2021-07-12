package ru.pronichev.list;

import ru.pronichev.collections.MyList;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size;

    public MyLinkedList() {
        this.firstElement = null;
        this.lastElement = null;
        this.size = 0;
    }

    @Override
    public void add(T element) {
        Node<T> node = new Node<>(element);
        if (size == 0) {
            firstElement = node;
        } else {
            lastElement.setNext(node);
        }
        lastElement = node;
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size == 0) {
            add(element);
        } else {
            Node<T> current = firstElement;
            for (var i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node<T> newElement = new Node<>(element);
            Node<T> next = current.getNext();
            current.setNext(newElement);
            newElement.setNext(next);
            size++;
        }
    }

    @Override
    public T get(int index) {
        Node<T> current = firstElement;
        for (var i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> current = firstElement;
        for (var i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        Node<T> returnValue = current.getNext();
        current.setNext(returnValue.getNext());
        size--;
        return returnValue.getValue();
    }

    @Override
    public T removeValue(T element) {
        if (element == null) {
            throw new IllegalArgumentException("argument should be not null");
        }
        Node<T> previous = firstElement;
        Node<T> current = firstElement;
        while (!current.getValue().equals(element)) {
            previous = current;
            current = current.getNext();

            if (current == null) {
                throw new IllegalArgumentException("not found");
            }
        }

        previous.setNext(current.getNext());
        size--;
        return current.getValue();
    }

    private static class Node<T> {
        private Node<T> next;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
