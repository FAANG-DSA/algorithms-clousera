package week1.algorithms;

public class QuickUnionAlgo {
    private int[] id;

    public QuickUnionAlgo(int N) {
        this.id = new int[N];
        for (int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    public int root(int i) {
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        id[root(p)] = root(q);
    }

    public static void main(String[] args) {
        QuickUnionAlgo obj = new QuickUnionAlgo(5);
        System.out.println(obj.isConnected(0, 1));
        System.out.println(obj.isConnected(1, 2));
        System.out.println(obj.isConnected(2, 3));
        System.out.println(obj.isConnected(3, 4));
        obj.union(0, 1);
        obj.union(0, 2);
        obj.union(1, 4);
        obj.union(2, 3);
        System.out.println(obj.isConnected(0, 1));
        System.out.println(obj.isConnected(1, 2));
        System.out.println(obj.isConnected(2, 3));
        System.out.println(obj.isConnected(3, 4));
    }
}
