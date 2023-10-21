package week2.assigments;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> head;
    private class Node<Item> {
        Item val;
        Node<Item> next;
        Node(Item item) {
            this.val = item;
        }
    }

    private class QueueIterator<Item> implements Iterator<Item> {
        private Node<Item> node;
        private Node<Item> head;
        private Node<Item> randomItem;
        private boolean firstIteration = true;

        public QueueIterator(Node<Item> node) {
            head = node;
            int random = StdRandom.uniformInt(1, size()+1);
            int count = 1;
            while (count != random) {
                node = node.next;
                count++;
            }
            randomItem = node;
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != randomItem || firstIteration;
        }

        @Override
        public Item next() {
            firstIteration = false;
            if (node == null) {
                throw new NoSuchElementException("");
            }
            Item val = this.node.val;
            if (node.next == null) {
                node = head;
            } else {
                node = node.next;
            }
            return val;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("");
        }

    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.head = null;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return head == null;
    }

    // return the number of items on the randomized queue
    public int size() {
        Node<Item> temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("");
        }
        Node<Item> node = new Node<>(item);
        node.next = head;
        head = node;
    }

    // remove and return a random item
    public Item dequeue() {
        int size = size();
        if (size < 1) throw new NoSuchElementException("");
        int rand = StdRandom.uniformInt(1, size() + 1);
        Node<Item> temp = head;
        Node<Item> prev = null;
        int count = 1;
        while (count <= (size-rand)) {
            prev = temp;
            temp = temp.next;
            count++;
        }
        if (prev != null) {
            prev.next = temp.next;
        }
        if (rand == size) {
            head = temp.next;
        }
        temp.next = null;
        return temp.val;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        int size = size();
        if (size < 1) throw new NoSuchElementException("");
        int rand = StdRandom.uniformInt(1, size() + 1);

        Node<Item> temp = head;
        int count = 1;
        while (count <= size-rand) {
            temp = temp.next;
            count++;
        }
        return temp.val;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new QueueIterator(this.head);
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(4);
        for (Integer integer : queue) {
            StdOut.println(integer);
        }
    }

}
