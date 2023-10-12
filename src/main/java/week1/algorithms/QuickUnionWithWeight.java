package week1.algorithms;

public class QuickUnionWithWeight {

    private int[] id;
    private int[] sz;

    public QuickUnionWithWeight(int n) {
        this.id = new int[n];
        this.sz = new int[n];
        for (int i=0; i<n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int root(int p) {
        while (id[p] != p) {
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

    private void getSize() {
        for(int i=0; i<sz.length; i++) {
            System.out.println(sz[i]);
        }
    }

    public static void main(String[] args) {
        QuickUnionWithWeight obj = new QuickUnionWithWeight(7);
        System.out.println(obj.isConnected(0, 1));
        System.out.println(obj.isConnected(1, 2));
        System.out.println(obj.isConnected(2, 3));
        System.out.println(obj.isConnected(3, 4));
        System.out.println(obj.isConnected(0, 5));
        System.out.println(obj.isConnected(5, 6));
        obj.union(0, 1);
        obj.union(1, 6);
        obj.union(0, 2);
        obj.union(3, 4);
        obj.union(4, 5);
        System.out.println(obj.isConnected(0, 1));
        System.out.println(obj.isConnected(1, 2));
        System.out.println(obj.isConnected(2, 3));
        System.out.println(obj.isConnected(3, 4));
        System.out.println(obj.isConnected(0, 5));
        obj.union(2, 4);

        System.out.println(obj.isConnected(0, 1));
        System.out.println(obj.isConnected(1, 2));
        System.out.println(obj.isConnected(2, 3));
        System.out.println(obj.isConnected(3, 4));
        System.out.println(obj.isConnected(0, 5));
        System.out.println(obj.isConnected(4, 6));

        obj.getSize();
    }
}