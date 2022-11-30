package Algorithm.ShotestPath;

import java.util.*;
import java.io.*;

class Node {
    int idx;
    int cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    public String toString() {
        return this.idx + " " + this.cost;
    }
}

public class Dijkstra {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static boolean[] visited;
    static StringBuilder sb = new StringBuilder("");

    static int final_cost;

    public static void search(int start, String FileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        ArrayList<String[]> vertex = new ArrayList<>();


        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            vertex.add(s);
            graph.add(new ArrayList<>());
        }

        for (String[] c : vertex) {
            for (int i = 1; i < c.length; i += 2) {
                Integer[] v = new Integer[3];
                int input_start = c[0].charAt(0) - 65;
                int input_end = c[i].charAt(0) - 65;
                int input_cost = Integer.parseInt(c[i + 1]);

                graph.get(input_start).add(new Node(input_end, input_cost));
            }
        }
//        System.out.println(graph.toString());

        int[] dist = new int[vertex.size()];

        for (int i = 0; i < vertex.size(); i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        visited = new boolean[vertex.size()];
        // 이후에 출발점 입력 받고 변경하는 과정 거칠것.
        dist[start] = 0;

        for (int i = 0; i < vertex.size(); i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for (int j = 0; j < vertex.size(); j++) {
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true;

            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node adjNode = graph.get(nodeIdx).get(j);
                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }
        }

        System.out.print("Dijkstra : ");
        for (int i = 0; i < vertex.size(); i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF");
            } else {
                System.out.print((char) (i + 65) + ":" + dist[i] + "   ");
            }
        }
        System.out.println();


        br.close();
    }

    public void init(){
        graph.clear();
    }
}
