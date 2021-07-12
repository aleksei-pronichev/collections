package ru.pronichev.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MyLinkedListTest {
    private static final int TEST_ARRAY_SIZE = 25;

    private int[] values;
    private MyLinkedList<Integer> myLinkedList;

    @BeforeEach
    void initValues() {
        this.values = new int[TEST_ARRAY_SIZE];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        myLinkedList = new MyLinkedList<>();
        for (int value : values) {
            myLinkedList.add(value);
        }
    }

    @Test
    void add() {
        int value = 3;
        int size = myLinkedList.size();
        myLinkedList.add(value);

        assertEquals(size + 1, myLinkedList.size());
        assertEquals(value, myLinkedList.get(size));
    }

    @Test
    void addIndex() {
        int insertValue = 20;
        int insertIndex = 3;
        myLinkedList.add(insertIndex, insertValue);

        System.out.println();
        assertEquals(insertValue, myLinkedList.get(insertIndex));
    }

    @Test
    void size() {
        assertEquals(values.length, myLinkedList.size());
    }

    @Test
    void get() {
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], myLinkedList.get(i));
        }
    }

    @Test
    void removeIndex() {
        int index = 3;

        int startSize = myLinkedList.size();
        int startValue = myLinkedList.get(3);

        myLinkedList.remove(index);

        assertEquals(startSize - 1, myLinkedList.size());
        assertNotEquals(startValue, myLinkedList.get(index));
    }

    @Test
    void removeValue() {
        Object value = 3;

        int startSize = myLinkedList.size();

        myLinkedList.removeValue((Integer) value);

        assertEquals(startSize - 1, myLinkedList.size());

        for (int i = 0; i < myLinkedList.size(); i++) {
            assertNotEquals(value, myLinkedList.get(i));
        }
    }
}