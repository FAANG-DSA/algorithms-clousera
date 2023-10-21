package week2.assigments;


public class TwoStackQueue<Integer> {
    private Stack stk1;
    private Stack stk2;

    public TwoStackQueue() {
        stk1 = new Stack();
        stk2 = new Stack();
    }
    public void push(int i) {
        stk1.push(i);
    }

    public void pop() {
        while (!stk1.isEmpty()) {
            stk2.push((int)stk1.peek());
            stk1.pop();
        }
        stk2.pop();
        while (!stk2.isEmpty()) {
            stk1.push((int)stk2.peek());
            stk2.pop();
        }
    }

    public int peek() {
        while (!stk1.isEmpty()) {
            stk2.push((int)stk1.peek());
            stk1.pop();
        }
        int last_val = (int)stk2.peek();
        while (!stk2.isEmpty()) {
            stk1.push((int)stk2.peek());
            stk2.pop();
        }
        return last_val;
    }

    public boolean isEmpty() {
        return stk1.isEmpty();
    }

    private class Stack {
        Node<Integer> head = null;
        public void push(int i) {
            Node prev = head;
            head = new Node(i);
            head.prev = prev;
        }

        public void pop() {
            if (head == null) {
                throw new RuntimeException("Stack is empty");
            }
            Node temp = head;
            head = head.prev;
            temp = null; // Make it available for GC
        }

        public Integer peek() {
            if (head == null) {
                throw new RuntimeException("Stack is empty");
            }
            return head.value;
        }

        public boolean isEmpty() {
            return head == null;
        }

        private class Node<Type> {
            Node prev;
            Type value;

            public Node(Type value) {
                this.value = value;
            }
        }
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        System.out.println(queue.isEmpty());
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        queue.pop();
        System.out.println(queue.isEmpty());
    }
}


