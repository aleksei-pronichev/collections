package ru.pronichev.collections;

public interface MyQueue<T> {
    void addLast(T element);

    T getFirst();

    T removeFirst();
}
