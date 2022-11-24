package Algorithm.GraphTraveral;

import java.io.*;
import java.util.*;

public class DFS {
    static Map<Integer, Integer[]> graph = new HashMap<>();
    public static void dfs(int v, boolean[] visited){
        visited[v] = true;
        System.out.print((char) (v + 65) + " ");

        for (int i : graph.get(v)) {
            if(!visited[i]) {
                dfs(i, visited);
            }
        }
    }
    public static void search() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Graph1.txt"));
        ArrayList<String[]> graph_arr = new ArrayList<>();

        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            graph_arr.add(s);
        }

        for (String[] c : graph_arr) {
            Integer[] v = new Integer[(int) c.length / 2];
            for (int i = 0; i < v.length; i++) {
                v[i] = c[i * 2 + 1].charAt(0) - 65;
            }
            graph.put((c[0].charAt(0) - 65), v);
        }

        boolean[] visited = new boolean[graph_arr.size()];

        System.out.print("DFS : ");
        dfs(0, visited); // 차후에 v는 입력 받은 것으로 바꿔야 함
        System.out.println();
    }
}
