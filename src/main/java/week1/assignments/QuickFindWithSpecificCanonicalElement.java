package week1.assignments;

import week1.algorithms.QuickUnionFindWithWeightAndPathCompression;

public class QuickFindWithSpecificCanonicalElement extends QuickUnionFindWithWeightAndPathCompression {
    private int[] id;
    private int[] sz;

    /**
     * https://www.coursera.org/learn/algorithms-part1/quiz/SCxqJ/interview-questions-union-find-ungraded/
     */
    public QuickFindWithSpecificCanonicalElement(int n) {
        super(n);
        id = super.id;
        sz = super.sz;
    }

    public int find(int p) {
        int pRoot = root(p);
        for (int i=id.length-1; i>=0; i--) {
            if (root(i) == pRoot) return i;
        }
        return p;
    }

    public static void main(String[] args) {
        QuickFindWithSpecificCanonicalElement ob = new QuickFindWithSpecificCanonicalElement(10);
        ob.union(1, 2);
        ob.union(2, 9);
        ob.union(9, 6);
        System.out.println(ob.find(1));
    }
}
