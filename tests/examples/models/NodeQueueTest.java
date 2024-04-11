package examples.models;

import opgave01.models.ArrayQueue;
import opgave01.models.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class NodeQueueTest {
    private Queue<String> sut;

    @BeforeEach
    void setUp() {
        sut = new ArrayQueue<>();
    }

    @Test
    @DisplayName("Add element to queue")
    void add() {
        int size = sut.size();
        sut.add("Test1");
        assertEquals(size + 1, sut.size());
        assertEquals("Test1", sut.element());
        sut.add("Test2");
        sut.remove();
        sut.add("Test3"); //circular test
        assertEquals(size + 2, sut.size());
        assertEquals("Test2", sut.element());
        sut.add("Test4"); //Adding elements over initial capacity
        assertEquals(size + 3, sut.size());
        assertEquals("Test2", sut.element());
    }


    @Test
    @DisplayName("Remove element from Queue")
    void remove() {
        sut.add("Test1");
        sut.add("Test2");

        String actual = sut.remove();
        assertEquals("Test1", actual);
        assertEquals(1, sut.size());
    }

    @Test
    @DisplayName("Remove element from empty queue")
    void removeFromEmptyQueue() {
        Exception actual = assertThrows(NoSuchElementException.class, () -> sut.remove());
        assertEquals("Queue is empty", actual.getMessage());
    }

    @Test
    @DisplayName("element from empty queue")
    void elementFromEmptyQueue() {
        Exception actual = assertThrows(NoSuchElementException.class, () -> sut.element());
        assertEquals("Queue is empty", actual.getMessage());
    }

    @Test
    @DisplayName("isEmpty")
    void isEmpty() {
        boolean actual = sut.isEmpty();
        assertTrue(actual);
        sut.add("Test");
        actual = sut.isEmpty();
        assertFalse(actual);
    }

    @Test
    @DisplayName("clear()")
    void clear() {
        sut.add("Test");
        sut.clear();
        assertEquals(0, sut.size());
        assertThrows(NoSuchElementException.class, () -> sut.element());
    }

    @Test
    void size() {
        int actual = sut.size();
        assertEquals(0, actual);
        sut.add("Test");
        actual = sut.size();
        assertEquals(1, actual);
        sut.remove();
        actual = sut.size();
        assertEquals(0, actual);
    }
}