package Algorithm.ShotestPath;

import java.io.*;
import java.util.*;

public class Floyd_Warshall {
    static int[][] dist;
    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Graph1.txt"));
        ArrayList<String[]> vertex = new ArrayList<>();


        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            vertex.add(s);
        }

        int len = vertex.size();

        dist = new int[len][len];
        for(int i = 0; i< len; i++) {
            for(int j = 0; j < len; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (String[] c : vertex) {
            for (int i = 1; i < c.length; i += 2) {
                int start = c[0].charAt(0) - 65;
                int end = c[i].charAt(0) - 65;
                int cost = Integer.parseInt(c[i + 1]);

                dist[start][end] = Math.min(dist[start][end], cost);
                dist[end][start] = Math.min(dist[end][start], cost);
            }
        }
        for (int i = 0; i < len; i++) {
            for(int j =0 ; j < len; j++) {
                if(dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("* ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
