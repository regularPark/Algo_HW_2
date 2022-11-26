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

    public String toString(){
        return this.v + " " + this.u + " " + this.cost;
    }
}

public class Sollin {
    public static ArrayList<Graph_Edge> graph = new ArrayList<Graph_Edge>();
    public static boolean[] visited;
    public static int final_cost = 0;
    public static void main(String[] args) throws IOException {
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
                int input_start = c[0].charAt(0) - 65;
                int input_end = c[i].charAt(0) - 65;
                int input_cost = Integer.parseInt(c[i + 1]);

                graph.add(new Graph_Edge(input_start, input_end, input_cost));
            }
        }

        for(Graph_Edge i : graph) {
            System.out.println(i.toString());
        }

//        System.out.println(graph.toString());

    }
}
