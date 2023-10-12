package week1.assignments;

import week1.algorithms.QuickUnionFindWithWeightAndPathCompression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SocialNetworkConnectivity {
    public static void main(String[] args) {
        System.out.println(SocialNetworkConnectivity.getMaxTimeWhenAllAreFriends());
    }

    public static String getMaxTimeWhenAllAreFriends() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        int n = 10;
        InputStream is = loader.getResourceAsStream("connect.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        int count = 0;
        String maxTimeStamp = "";
        try {
            for (String line; (line = reader.readLine()) != null;) {
                String[] arr = line.split(" ");
                int i = Integer.parseInt(arr[0]);
                int j = Integer.parseInt(arr[1]);
                QuickUnionFindWithWeightAndPathCompression unionAndFind = new QuickUnionFindWithWeightAndPathCompression(n);
                if (!unionAndFind.isConnected(i, j)) {
                    unionAndFind.union(i, j);
                    count++;
                }
                if (count == n-1) {
                    maxTimeStamp= arr[2] + " " + arr[3];
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return maxTimeStamp;
    }
}
