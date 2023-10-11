import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int count = 1;
        while (!StdIn.isEmpty()) {
            System.out.println(StdIn.readString());
        }
        System.out.println(StdRandom.bernoulli((double) 1/count));
    }
}
