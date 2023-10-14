package week1.assignments;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] percolationThreshold;
    private int grid;
    private int trails;

    public PercolationStats(int n, int trails) {
        if (n <= 0 || trails <= 0) {
            throw new IllegalArgumentException();
        }
        percolationThreshold = new double[trails];
        this.grid = n;
        this.trails = trails;
        int count = 0;
        while (count < trails) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniformInt(1, n+1), StdRandom.uniformInt(1, n+1));
            }
            int openSites = percolation.numberOfOpenSites();
            percolationThreshold[count] = openSites / Math.pow(n, 2);
            count++;
        }
    }

    public double mean() {
        return StdStats.mean(percolationThreshold);
    }

    public double stddev() {
        return StdStats.stddev(percolationThreshold);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev()) / Math.sqrt(trails);
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev()) / Math.sqrt(trails);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException();
        }
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(n, t);
        StdOut.printf("mean = %f\n", percolationStats.mean());
        StdOut.printf("stddev = %f\n", percolationStats.stddev());
        StdOut.printf("95%s confidence interval = [%f, %f]", "%", percolationStats.confidenceLo(), percolationStats.confidenceHi());
    }
}
