package ru.pronichev.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MyArrayListTest {
    private static final int TEST_ARRAY_SIZE = 25;

    private int[] values;
    private MyArrayList<Integer> myArrayList;

    @BeforeEach
    void initValues() {
        this.values = new int[TEST_ARRAY_SIZE];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
         myArrayList = new MyArrayList<>();
        for (int value : values) {
            myArrayList.add(value);
        }
    }

    @Test
    void create() throws NoSuchFieldException, IllegalAccessException {
        MyArrayList<String> arrayList = new MyArrayList<>();

        Field capacityField = MyArrayList.class.getDeclaredField("DEFAULT_INITIAL_SIZE");
        capacityField.setAccessible(true);
        Field arrayField = arrayList.getClass().getDeclaredField("array");
        arrayField.setAccessible(true);
        int defaultCapacity = capacityField.getInt(arrayList);
        Object[] array = (Object[]) arrayField.get(arrayList);

        assertEquals(defaultCapacity, array.length);
        assertEquals(0, arrayList.size());

        int initialCapacity = 20;
        arrayList = new MyArrayList<>(20);
        array = (Object[]) arrayField.get(arrayList);

        assertEquals(initialCapacity, array.length);
        assertEquals(0, arrayList.size());

        capacityField.setAccessible(false);
        arrayField.setAccessible(false);
    }

    @Test
    void add() {
        int value = 3;
        int size = myArrayList.size();
        myArrayList.add(value);

        assertEquals(size + 1, myArrayList.size());
        assertEquals(value, myArrayList.get(size));
    }

    @Test
    void addIndex() {
        int insertValue = 20;
        int insertIndex = 3;
        myArrayList.add(insertIndex, insertValue);

        System.out.println();
        assertEquals(insertValue, myArrayList.get(insertIndex));
    }

    @Test
    void size() {
        assertEquals(values.length, myArrayList.size());
    }

    @Test
    void get() {
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], myArrayList.get(i));
        }
    }

    @Test
    void removeIndex() {
        int index = 3;

        int startSize = myArrayList.size();
        int startValue = myArrayList.get(3);

        myArrayList.remove(index);

        assertEquals(startSize - 1, myArrayList.size());
        assertNotEquals(startValue, myArrayList.get(index));
    }

    @Test
    void removeValue() {
        Object value = 3;

        int startSize = myArrayList.size();
        System.out.println(myArrayList.get(3));

        myArrayList.remove((Integer) value);

        assertEquals(startSize - 1, myArrayList.size());

        for (int i = 0; i < myArrayList.size(); i++) {
            assertNotEquals(value, myArrayList.get(i));
        }
    }
}