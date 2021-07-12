package ru.pronichev.collections;

public interface MyStack<T> {
    int size();

    void push(T element);

    T peek();

    T pop();
}
