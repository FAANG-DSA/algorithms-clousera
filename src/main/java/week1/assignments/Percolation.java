package week1.assignments;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int grid;
    private int elements;
    private int[] ids;
    private WeightedQuickUnionUF weightedQuickUnionUF;
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.elements = (int) Math.pow(n, 2) + 2;
        this.weightedQuickUnionUF = new WeightedQuickUnionUF(elements);
        this.grid = n;
        this.ids = new int[elements];
        for (int i = 0; i < ids.length; i++) {
            if (i == 0 || i == ids.length-1) {
                ids[i] = 1;
            } else {
                ids[i] = 0;
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (row < 1 || col < 1 || row > grid || col > grid) {
            throw new IllegalArgumentException();
        }
        int index = grid * (row-1) + col;
        return ids[index] == 1;
    }

    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }
        if (row < 1 || col < 1 || row > grid || col > grid) {
            throw new IllegalArgumentException();
        }
        int index = grid * (row-1) + col;
        ids[index] = 1;
        if (row == 1) {
            weightedQuickUnionUF.union(0, index);
        }
        if (row == grid) {
            weightedQuickUnionUF.union(elements-1, elements-1-grid+(col-1));
        }
        if (((col-1) >= 1) && ids[(((row-1) * grid) + col-1)] == 1) {
            weightedQuickUnionUF.union((((row-1) * grid) + col-1), (((row-1) * grid) + col));
        }
        if ((col+1 <= grid) && ids[(((row-1) * grid) + col + 1)] == 1) {
            weightedQuickUnionUF.union((((row-1) * grid) + col), (((row-1) * grid) + col+1));
        }
        if ((row-1 >= 1) && ids[(((row-2) * grid) + col)] == 1) {
            weightedQuickUnionUF.union((((row-1) * grid) + col), (((row-2) * grid) + col));
        }
        if ((row+1 <= grid) && ids[(((row) * grid) + col)] == 1) {
            weightedQuickUnionUF.union((((row-1) * grid) + col), (((row) * grid) + col));
        }
    }

    public boolean isFull(int row, int col) {
        int index = this.grid * (row-1) + col;
        if (row < 1 || col < 1 || row > grid || col > grid) {
            throw new IllegalArgumentException();
        }
        return weightedQuickUnionUF.connected(0, index);
    }

    public int numberOfOpenSites() {
        int count = 0;
        for (int i = 1; i < ids.length-1; i++) {
            if (ids[i] == 1) {
                count++;
            }
        }
        return count;
    }

    public boolean percolates() {
        return weightedQuickUnionUF.connected(0, ids.length-1);
    }
}
