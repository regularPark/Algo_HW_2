package Algorithm.MST;

import java.util.*;
import java.io.*;

class Graph_Edge {
    int v;
    int u;
    int cost;

    Graph_Edge(int v, int u, int cost) {
        this.v = v;
        this.u = u;
        this.cost = cost;
    }

    public String toString() {
        return this.v + " " + this.u + " " + this.cost;
    }
}

public class Sollin {
    public static ArrayList<Graph_Edge> graph = new ArrayList<Graph_Edge>();
    public static boolean[] visited;
    static int parent[];
    static int Min[];
    public static int final_cost = 0;
    static StringBuilder sb = new StringBuilder("");

    public static void search(String FileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        ArrayList<String[]> vertex = new ArrayList<>();


        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            vertex.add(s);
        }

        for (String[] c : vertex) {
            for (int i = 1; i < c.length; i += 2) {
                Integer[] v = new Integer[3];
                int input_start = c[0].charAt(0) - 65;
                int input_end = c[i].charAt(0) - 65;
                int input_cost = Integer.parseInt(c[i + 1]);

                graph.add(new Graph_Edge(input_start, input_end, input_cost));
            }
        }


        int edges = graph.size();
        int components = vertex.size();
        final_cost = 0;

        parent = new int[components];
        Min = new int[components];
        for (int i = 0; i < components; i++) {
            parent[i] = i;
        }

        while (components > 1) {
            for (int i = 0; i < vertex.size(); i++) {
                Min[i] = -1;
            }
            for (int i = 0; i < edges; i++) {
                if (root(graph.get(i).v) == root(graph.get(i).u)) continue;

                int r_v = root(graph.get(i).v);
                if (Min[r_v] == -1 || graph.get(i).cost < graph.get(Min[r_v]).cost) {
                    Min[r_v] = i;
                }

                int r_u = root(graph.get(i).u);
                if (Min[r_u] == -1 || graph.get(i).cost < graph.get(Min[r_u]).cost) {
                    Min[r_u] = i;
                }
            }
            for (int i = 0; i < vertex.size(); i++) {
                if (Min[i] != -1) {
                    if (merge(graph.get(Min[i]).v, graph.get(Min[i]).u)) {
                        final_cost += graph.get(Min[i]).cost;
                        components--;
                    }
                }
            }
        }
        System.out.println("선택된 간선 : " + sb);
        System.out.println("최종 비용 : " + final_cost);
    }

    public void init() {
        graph.clear();
        sb.setLength(0);
        final_cost = 0;
    }

    static int root(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = root(parent[v]);
    }

    static boolean merge(int v, int u) {
        v = root(v);
        u = root(u);
        if (v == u) {
            return false;
        }
        parent[v] = u;
        sb.append((char) (v + 65) + "->" + (char) (u + 65) + "   ");

        return true;
    }
}
