package Algorithm.GraphTraveral;

import java.util.*;
import java.io.*;

// ASCII 코드로 변형해서 LinkedList로 이용하자...

public class BFS {
    static Map<String, String[]> graph = new HashMap<>();

    public static void BFS(boolean[] visited) {
        Queue<String> q = new LinkedList<String>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Graph1.txt"));
        ArrayList<String[]> graph_arr = new ArrayList<>();

        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            graph_arr.add(s);
        }

        for (String[] c : graph_arr) {
            String[] v = new String[(int) c.length / 2];
            for (int i = 0; i < v.length; i++) {
                v[i] = c[i * 2 + 1];
            }
            graph.put(c[0], v);
        }

        boolean[] visited = new boolean[graph_arr.size()];

        graph.entrySet().forEach(item -> System.out.println(item.getKey() + " : " + Arrays.toString(item.getValue())));
        System.out.println(Arrays.toString(visited));

        BFS(visited);
    }
}
