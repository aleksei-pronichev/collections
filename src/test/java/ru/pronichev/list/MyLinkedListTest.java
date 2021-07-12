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

        int removeValue = myLinkedList.remove(index);

        assertEquals(startSize - 1, myLinkedList.size());
        assertEquals(startValue, removeValue);
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

    @Test
    void push() {
        int value = 3;
        int size = myLinkedList.size();
        myLinkedList.push(value);

        assertEquals(size + 1, myLinkedList.size());
        assertEquals(value, myLinkedList.get(size));
    }

    @Test
    void peek() {
        int size = myLinkedList.size();
        for (int i = values.length - 1; i >= 0; i--) {
            assertEquals(values[i], myLinkedList.peek());
            assertEquals(size, myLinkedList.size());
            myLinkedList.remove(i);
            size--;
        }
    }

    @Test
    void pop() {
        int size = myLinkedList.size();
        for (int i = values.length - 1; i >= 0; i--) {
            assertEquals(values[i], myLinkedList.pop());
            assertEquals(--size, myLinkedList.size());
        }
    }

    @Test
    void addLast() {
        int value = 3;
        int size = myLinkedList.size();
        myLinkedList.addLast(value);

        assertEquals(size + 1, myLinkedList.size());
        assertEquals(value, myLinkedList.get(size));
    }

    @Test
    void getFirst() {
        int size = myLinkedList.size();
        for (int value : values) {
            assertEquals(value, myLinkedList.getFirst());
            assertEquals(size, myLinkedList.size());
            myLinkedList.remove(0);
            size--;
        }
    }

    @Test
    void removeFirst() {
        int size = myLinkedList.size();
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], myLinkedList.removeFirst());
            assertEquals(--size, myLinkedList.size());
        }
    }
}