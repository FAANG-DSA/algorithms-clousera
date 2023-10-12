package week1.algorithms;

public class QuickFindWithPathCompression {
    private int[] id;

    public QuickFindWithPathCompression(int N) {
        this.id = new int[N];
        for (int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    public int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]]; // Just added this line in week1.algorithms.QuickUnionAlgo
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        System.out.printf("Is %d and %d connected: ", p, q);
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        id[root(p)] = root(q);
    }

    public static void main(String[] args) {
        QuickFindWithPathCompression obj = new QuickFindWithPathCompression(7);
        System.out.println("===================== Without any connection ========================");
//      Without any connection
        System.out.println(obj.isConnected(0, 1));
        System.out.println(obj.isConnected(1, 2));
        System.out.println(obj.isConnected(2, 3));
        System.out.println(obj.isConnected(3, 4));
        System.out.println(obj.isConnected(0, 5));
        System.out.println(obj.isConnected(5, 6));

//      Connect 0-1-2-6 and 3-4-5
        obj.union(0, 1);
        obj.union(1, 6);
        obj.union(0, 2);
        obj.union(3, 4);
        obj.union(4, 5);

        System.out.println("===================== Connect 0-1-2-6 and 3-4-5 ========================");
        System.out.println(obj.isConnected(0, 1));
        System.out.println(obj.isConnected(1, 2));
        System.out.println(obj.isConnected(2, 3));
        System.out.println(obj.isConnected(3, 4));
        System.out.println(obj.isConnected(0, 5));

        System.out.println("================= Connect 2-6. At this point all should be connected. ===================");
//      Connect 2-6. At this point all should be connected.
        obj.union(2, 4);
        System.out.println(obj.isConnected(0, 1));
        System.out.println(obj.isConnected(1, 2));
        System.out.println(obj.isConnected(2, 3));
        System.out.println(obj.isConnected(3, 4));
        System.out.println(obj.isConnected(0, 5));
        System.out.println(obj.isConnected(4, 6));
    }
}
