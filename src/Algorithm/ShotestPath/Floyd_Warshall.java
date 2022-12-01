package Algorithm.ShotestPath;

import java.io.*;
import java.util.*;

public class Floyd_Warshall {
    static int[][] dist;

    public static void search(int input_start, String FileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        ArrayList<String[]> vertex = new ArrayList<>();


        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            vertex.add(s);
        }

        if (input_start >= vertex.size()) {
            System.out.println("출발점이 범위를 벗어났습니다.");
            return;
        }

        int len = vertex.size();

        dist = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = 100_000_000;
            }
        }

        for (String[] c : vertex) {
            for (int i = 1; i < c.length; i += 2) {
                int start = c[0].charAt(0) - 65;
                int end = c[i].charAt(0) - 65;
                int cost = Integer.parseInt(c[i + 1]);

                if (!FileName.equals("Graph5.txt") && !FileName.equals("Graph6.txt")) {
                    dist[start][end] = Math.min(dist[start][end], cost);
                    dist[end][start] = Math.min(dist[end][start], cost);
                }
                if (FileName.equals("Graph5.txt") || FileName.equals("Graph6.txt")) {
                    dist[start][end] = Math.min(dist[start][end], cost);
                }
            }
        }

        for (int i = input_start; i < len; i++) {
            for (int j = input_start; j < len; j++) {
                for (int k = input_start; k < len; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
        if (input_start != 0) {
            for (int i = input_start - 1; i >= 0; i--) {
                for (int j = input_start - 1; j >= 0; j--) {
                    for (int k = input_start - 1; k >= 0; k--) {
                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    }
                }
            }
        }


        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dist[i][j] == 100_000_000) {
                    System.out.print("*\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

}
