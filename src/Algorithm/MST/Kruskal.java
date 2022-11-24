package Algorithm.MST;

import java.io.*;
import java.util.*;

public class Kruskal {
    static ArrayList<Integer[]> graph = new ArrayList<>();
    static int[] parent;
    static int final_cost;

    public static void search() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Graph1.txt"));
        ArrayList<String[]> vertex = new ArrayList<>();


        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            vertex.add(s);
        }

        for (String[] c : vertex) {
            for (int i = 1; i < c.length; i += 2) {
                Integer[] v = new Integer[3];
                v[0] = c[0].charAt(0) - 65;
                v[1] = c[i].charAt(0) - 65;
                v[2] = Integer.parseInt(c[i + 1]);
                graph.add(v);
            }
        }

        graph.sort((a, b) -> a[2].compareTo(b[2]));

        parent = new int[vertex.size()];
        final_cost = 0;

        for (int i = 0; i < vertex.size(); i++) {
            parent[i] = i;
        }

        for (int i = 0; i < graph.size(); i++) {
            if (find(graph.get(i)[0]) != find(graph.get(i)[1])) {
                System.out.println("<선택된 간선>");
                System.out.println((char) (graph.get(i)[0] + 65) + " " + (char) (graph.get(i)[1] + 65));
                union(graph.get(i)[0], graph.get(i)[1]);
                final_cost += graph.get(i)[2];
                continue;
            }
        }
        System.out.println("<각 노드가 가리키고 있는 부모>");
        for (int i = 0 ; i < parent.length; i++) {
            System.out.print((char)(i + 65)+ " ");
        }
        System.out.println("");
        for(int i : parent) {
            System.out.print((char)(i + 65)+ " ");
        }

        System.out.println("\n최종 비용 : " + final_cost);


//        for(Integer[] i : graph) {
//            System.out.println(Arrays.toString(i));
//        }

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }
}
