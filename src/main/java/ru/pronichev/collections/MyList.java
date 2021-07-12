package ru.pronichev.collections;

public interface MyList<T> {
    void add(T obj);

    void add(int index, T obj);

    T get(int index);

    int size();

    T remove(int index);

    T remove(T obj);
}
