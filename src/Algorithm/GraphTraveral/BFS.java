package Algorithm.GraphTraveral;

import java.util.*;
import java.io.*;

public class BFS {
    static Map<Integer, Integer[]> graph = new HashMap<>();

    public static void bfs(int v, boolean[] visited) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print((char) (v + 65) + " ");
            Integer[] arr = graph.get(v);
            for (int i : arr) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void search() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Graph1.txt"));
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

        System.out.print("BFS : ");
        bfs(0, visited);
        System.out.println();

        // 출력부, 아스키코드 역순으로 출력하면 될듯.
//        graph.entrySet().forEach(item -> System.out.println(item.getKey() + " : " + Arrays.toString(item.getValue())));
//        System.out.println(Arrays.toString(visited));
    }
}
