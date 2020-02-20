package e4e5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {
    int count = 0;
    @BeforeEach public void setUp() {
        System.out.println("Run test method: "+(++count));
    }
    @AfterEach public void tearDown() {
        System.out.println(" --- done with test " + count);
    }

    private LinkedQueue build(int size) {
        LinkedQueue l = new LinkedQueue();
        for (int i = 0; i<size; i++) {
            l.enqueue(i);
        }
        return l;
    }

    private LinkedQueue buildRandom(int size) {
        LinkedQueue l = new LinkedQueue();
        for (int i = 0; i<size; i++) {
            l.enqueue((int) Math.random()*Integer.MAX_VALUE);
        }
        return l;
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(5,build(5).size());
        assertEquals(0,build(0).size());
        assertEquals(0,build(-1).size());

    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertEquals(true, build(0).isEmpty());
        assertEquals(false, build(5).isEmpty());
        assertEquals(true, build(-1).isEmpty());
    }

    @org.junit.jupiter.api.Test
    void enqueue() {
    }

    @org.junit.jupiter.api.Test
    void dequeue() {
    }

    @org.junit.jupiter.api.Test
    void first() {
        assertEquals(0, build(5).first());
        assertEquals(0, build(0).first());
    }

    @org.junit.jupiter.api.Test
    void last() {
        assertEquals(0, build(5).first());
        assertEquals(0, build(0).first());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("0  1  ", build(2).toString());
    }
}