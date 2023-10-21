package week2.assigments;

public class StackUsingArray {

    private int[] arr;
    private int filledIndex = 0;
    private int capacity;

    public StackUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    private void resize() {
        if (filledIndex == capacity) {
            capacity = capacity * 2;
            int[] j = new int[capacity];
            for (int i = 0; i < filledIndex; i++) {
                j[i] = arr[i];
            }
            arr = j;
        }
    }

    private void shrink() {
        if (filledIndex <= capacity / 4) {
            capacity = capacity / 2;
            int[] j = new int[capacity];
            for (int i = 0; i < filledIndex; i++) {
                j[i] = arr[i];
            }
            arr = j;
        }
    }

    public void push(int i) {
        resize();
        arr[filledIndex++] = i;
    }

    public int pop() {
        if (filledIndex <= 0) {
            throw new RuntimeException("StackUnderFlow");
        }
        shrink();
        System.out.printf("Size: %d\n",arr.length);
        return arr[--filledIndex];
    }

    public static void main(String[] args) {
        StackUsingArray stk = new StackUsingArray(10);
        stk.push(10);
        stk.push(110);
        stk.push(120);
        stk.push(30);
        stk.push(130);
        stk.push(90);
        stk.push(100);
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
