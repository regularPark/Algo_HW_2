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
    public static void search(int start, String FileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        ArrayList<String[]> vertex = new ArrayList<>();

        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            vertex.add(s);
        }

        for (String[] c : vertex) {
            Integer[] v = new Integer[(int) c.length / 2];
            for (int i = 0; i < v.length; i++) {
                v[i] = c[i * 2 + 1].charAt(0) - 65;
            }
            graph.put((c[0].charAt(0) - 65), v);
        }

        boolean[] visited = new boolean[vertex.size()];

        System.out.print("DFS : ");
        if(start < vertex.size()){
            dfs(start, visited);
        } else {
            System.out.print("출발점이 범위를 벗어났습니다.");
        }
        System.out.println();
    }
}
