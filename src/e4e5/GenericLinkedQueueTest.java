package e4e5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.JUnitException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedQueueTest {


    @BeforeEach
    void setUp() {
        System.out.println("Starting test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finished test");
    }

    @Test
    void size() {
        GenericLinkedQueue<String> que2 = new GenericLinkedQueue<String>();
        try {
            que2.dequeue();
            fail();
        } catch (Exception e) {
        }

        assertEquals(0, que2.size());
        que2.enqueue("1");
        assertEquals(1, que2.size());
        que2.enqueue("1");
        assertEquals(2, que2.size());

        GenericLinkedQueue<Integer> que = new GenericLinkedQueue<Integer>();
        assertEquals(0, que.size());
        que.enqueue(2);
        assertEquals(1, que.size());
        que.enqueue(1);
        assertEquals(2, que.size());

    }

    @Test
    void isEmpty() {
        GenericLinkedQueue<String> que2 = new GenericLinkedQueue<String>();
        GenericLinkedQueue<Integer> que = new GenericLinkedQueue<Integer>();

        assertEquals(true, que.isEmpty());
        assertEquals(true, que2.isEmpty());
        que.enqueue(5);
        que2.enqueue("lol");
        assertEquals(false, que.isEmpty());
        assertEquals(false, que2.isEmpty());
    }

    @Test
    void enqueue() {
        GenericLinkedQueue<String> que2 = new GenericLinkedQueue<String>();

        que2.enqueue("5");
        assertEquals("5", que2.dequeue());
        que2.enqueue("6");
        que2.enqueue("7");
        que2.enqueue("8");
        assertEquals("6", que2.dequeue());
        assertEquals("7", que2.dequeue());
        assertEquals("8", que2.dequeue());


        GenericLinkedQueue<Integer> que = new GenericLinkedQueue<Integer>();
        assertThrows(NoSuchElementException.class, ()->{
            que.dequeue();
        });
        que.enqueue(5);
        assertEquals(5, que.dequeue());
        que.enqueue(6);
        que.enqueue(7);
        que.enqueue(8);
        assertEquals(6, que.dequeue());
        assertEquals(7, que.dequeue());
        assertEquals(8, que.dequeue());

    }

    @Test
    void dequeue() {
        GenericLinkedQueue<String> que2 = new GenericLinkedQueue<String>();

        assertThrows(NoSuchElementException.class, ()->{
            que2.dequeue();
        });
        que2.enqueue("5");
        assertEquals("5", que2.dequeue());
        que2.enqueue("6");
        que2.enqueue("7");
        que2.enqueue("8");
        assertEquals("6", que2.dequeue());
        assertEquals("7", que2.dequeue());
        assertEquals("8", que2.dequeue());


        GenericLinkedQueue<Integer> que = new GenericLinkedQueue<Integer>();
        assertThrows(NoSuchElementException.class, ()->{
            que.dequeue();
        });
        que.enqueue(5);
        assertEquals(5, que.dequeue());
        que.enqueue(6);
        que.enqueue(7);
        que.enqueue(8);
        assertEquals(6, que.dequeue());
        assertEquals(7, que.dequeue());
        assertEquals(8, que.dequeue());

    }

    @Test
    void first() {
        GenericLinkedQueue<String> que2 = new GenericLinkedQueue<String>();

        assertThrows(NoSuchElementException.class, ()->{
            que2.first();
        });
        que2.enqueue("lol");
        assertEquals("lol", que2.first());
        que2.enqueue("asd");
        assertEquals("lol", que2.first());
        GenericLinkedQueue<Integer> que = new GenericLinkedQueue<Integer>();

        assertThrows(NoSuchElementException.class, ()->{
            que.first();
        });

        que.enqueue(5);
        assertEquals(5, que.first());
        que.enqueue(2);
        assertEquals(5, que.first());

    }

    @Test
    void last() {

        GenericLinkedQueue<String> que2 = new GenericLinkedQueue<String>();

        assertThrows(NoSuchElementException.class, ()->{
            que2.last();
        });
        que2.enqueue("lol");
        assertEquals("lol", que2.last());
        que2.enqueue("asd");
        assertEquals("asd", que2.last());
        GenericLinkedQueue<Integer> que = new GenericLinkedQueue<Integer>();

        assertThrows(NoSuchElementException.class, ()->{
            que.last();
        });

        que.enqueue(5);
        assertEquals(5, que.last());
        que.enqueue(2);
        assertEquals(2, que.last());

    }

    @Test
    void testToString() {
        GenericLinkedQueue<Integer> que = new GenericLinkedQueue<Integer>();
        que.enqueue(5);
        que.enqueue(2);
        que.enqueue(1);
        assertEquals("5 2 1 ", que.toString());
        GenericLinkedQueue<String> que2 = new GenericLinkedQueue<String>();
        que2.enqueue("5");
        que2.enqueue("2");
        que2.enqueue("1");
        assertEquals("5 2 1 ", que2.toString());
    }

    @Test
    void iterator() {
        GenericLinkedQueue<String> que2 = new GenericLinkedQueue<String>();
        assertThrows(NoSuchElementException.class, ()->{
            que2.iterator().next();
        });
        assertEquals(false, que2.iterator().hasNext());
        que2.enqueue("lol");
        assertEquals(true, que2.iterator().hasNext());
        que2.enqueue("asd");
        assertEquals(true, que2.iterator().hasNext());
        assertEquals("lol", que2.iterator().next());



        GenericLinkedQueue<Integer> que = new GenericLinkedQueue<Integer>();

        assertThrows(NoSuchElementException.class, ()->{
            que.iterator().next();
        });
        assertEquals(false, que.iterator().hasNext());
        que.enqueue(5);
        assertEquals(true, que.iterator().hasNext());
        que.enqueue(2);
        assertEquals(true, que.iterator().hasNext());
        assertEquals(5, que.iterator().next());


    }
}