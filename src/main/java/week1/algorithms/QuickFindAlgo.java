package week1.algorithms;

public class QuickFindAlgo {
    private int[] id;
    public QuickFindAlgo(int N) {
        this.id = new int[N];
        for (int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int i, int j) {
        return id[i] == id[j];
    }

    public void union(int p, int q) {
        int pVal = id[p];
        int qVal = id[q];
        id[q] = pVal;
        for (int i=0; i<id.length; i++) {
            if (id[i] == qVal) id[i] = qVal;
        }
    }

    public static void main(String[] args) {
        QuickFindAlgo obj = new QuickFindAlgo(5);
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
