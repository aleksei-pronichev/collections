package ru.pronichev.collections;

public interface MyList<T> {
    void add(T element);

    void add(int index, T element);

    T get(int index);

    int size();

    T remove(int index);

    T removeValue(T element);
}
