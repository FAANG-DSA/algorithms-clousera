package week1.algorithms;

public class QuickUnionFindWithWeightAndPathCompression {

    protected int[] id;
    protected int[] sz;

    public QuickUnionFindWithWeightAndPathCompression(int n) {
        this.id = new int[n];
        this.sz = new int[n];
        for (int i=0; i<n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int root(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]]; // Just added this line for Path Compression
            p = id[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        if (sz[p] > sz[q]) {
            id[root(q)] = root(p);
            sz[p] = sz[p] + sz[q];
        } else {
            id[root(p)] = root(q);
            sz[q] = sz[p] + sz[q];
        }
    }

    public static void main(String[] args) {
        QuickUnionFindWithWeightAndPathCompression obj = new QuickUnionFindWithWeightAndPathCompression(7);
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
