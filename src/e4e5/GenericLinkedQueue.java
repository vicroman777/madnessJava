package e4e5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericLinkedQueue<T> implements Queue<T> {

    int size = 0;
    Node<T> first;
    Node<T> last;

    class Node<T> {
        T x;
        private Node<T> next;
        public Node(T element) {
            this.x = element;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (first == null) {
        return true;}
        else return false;
    }


    @Override
    public void enqueue(T element) {
        Node<T> el = new Node<T>(element);
        if (first == null) {
            first = el;
        } else {
            if (first.next == null) {
                first.next = el;
            } else {
                last.next = el;
            }


        }
        last = el;
        size++;
    }

    @Override
    public T dequeue() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T temp = first.x;
        first = first.next;
        size--;

        return temp;
    }

    @Override
    public T first() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.x;
    }

    @Override
    public T last() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.x;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator<T> n = iterator();
        while (n.hasNext()) {
            s.append(n.next() + " ");
        }
        String toString = s.toString();
        return toString;
    };

    @Override
    public Iterator<T> iterator() {
        return new IteratorClass();
       }


    class IteratorClass implements Iterator<T> {
         private Node<T> cur = first;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {throw new NoSuchElementException();}
                T currentEl = cur.x;
            cur = cur.next;
            return currentEl;
        }
    }



}