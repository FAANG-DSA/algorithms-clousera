package week2.assigments;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;

    // construct an empty deque
    public Deque() {
        this.head = null;
        this.tail = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return (this.head == null && this.tail == null);
    }

    // return the number of items on the deque
    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        Iterator<Item> itr = new QueueIterator<>(head);
        while (itr.hasNext()) {
            itr.next();
            count++;
        }
        return count;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("");
        }
        Node<Item> node = new Node<>(item);
        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            Node<Item> temp = this.head;
            temp.prev = node;
            node.next = temp;
            this.head = node;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("");
        }
        Node<Item> node = new Node<>(item);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = null;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (head == null && tail == null) {
            throw new NoSuchElementException("");
        }
        Node<Item> temp = head;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        Item item = temp.item;
        temp = null;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (head == null && tail == null) {
            throw new NoSuchElementException("");
        }
        Item item = tail.item;
        Node<Item> temp = tail;
        if (temp.prev == null) {
            head = null;
            tail = null;
        } else {
            tail = temp.prev;
        }
        if (tail != null) {
            tail.next = null;
        }
        temp.prev = null;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new QueueIterator(head);
    }

    private class QueueIterator<Item> implements Iterator<Item> {
        private Node<Item> node;

        public QueueIterator(Node<Item> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Item next() {
            if (node == null) {
                throw new NoSuchElementException("");
            }
            Item val = node.item;
            this.node = node.next;
            return val;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("");
        }

    }

    private class Node<Item> {
        public Node<Item> prev;
        public Node<Item> next;
        public Item item;

        Node(Item val) {
            if (val == null) {
                throw new IllegalArgumentException();
            }
            this.item = val;
        }
    }
    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        StdOut.println(deque.isEmpty());
        deque.addFirst(2);
        deque.iterator();
        StdOut.println(deque.size());
    }

}
