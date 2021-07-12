package ru.pronichev.list;

import ru.pronichev.collections.MyList;

public class MyArrayList<T>  implements MyList<T> {
    private static final int DEFAULT_INITIAL_SIZE = 10;

    private Object[] array;
    private int size;

    public MyArrayList() {
        this(DEFAULT_INITIAL_SIZE);
    }

    public MyArrayList(int size) {
        this.array = new Object[size];
        this.size = 0;
    }

    @Override
    public void add(T obj) {
        checkIncreaseArray();
        array[size] = obj;
        size++;
    }

    @Override
    public void add(int index, T obj) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Only positive numbers");
        }
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException("index is bigger than array size");
        }
        checkIncreaseArray();
        System.arraycopy(array, index, array, index + 1,  size - index);
        array[index] = obj;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) array[index];
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
        Object obj = array[index];
        System.arraycopy(array, index + 1, array, index ,  size - index + 1);
        size--;
        return (T) obj;
    }

    @Override
    public T remove(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("argument should be not null");
        }
        for (int i = 0; i < array.length; i++) {
            if (obj.equals(array[i])) {
                return remove(i);
            }
        }
        throw new IllegalArgumentException("element not found");
    }

    private void checkIncreaseArray() {
        if (size >= array.length) {
            Object[] temp = array;
            array = new Object[temp.length * 2];
            System.arraycopy(temp, 0, array, 0, size);
        }
    }
}
