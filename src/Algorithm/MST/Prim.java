package Algorithm.MST;

import com.sun.javafx.scene.traversal.Algorithm;

import javax.swing.event.InternalFrameAdapter;
import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int start;
    int end;
    int cost;

    Node(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node node) {
        return node.cost >= this.cost ? -1 : 1;
    }

    public String toString() {
        return String.valueOf(this.start + " " + this.end + " " + this.cost + "\n");
    }
}

public class Prim {
    public static ArrayList<Node>[] nodeList;
    public static ArrayList<Node> graph = new ArrayList<Node>();
    public static boolean[] visited;
    static StringBuilder sb = new StringBuilder("");
    static int cost = 0;

    public static void search(int start_, String FileName) throws IOException {
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
                graph.add(new Node(input_start, input_end, input_cost));
            }
        }

        nodeList = new ArrayList[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            nodeList[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < graph.size(); i++) {
            int start = graph.get(i).start;
            int end = graph.get(i).end;
            int cost = graph.get(i).cost;
            nodeList[start].add(new Node(start, end, cost));
            nodeList[end].add(new Node(end, start, cost));
        }

        visited = new boolean[graph.size()];
        Arrays.fill(visited, false);
        prim(start_); // 추후 시작 지점 입력받기. 현재는 A로 시작한 경우임
//        System.out.println(graph.toString());
        System.out.println("방문 순서 : " + (char) (start_ + 65) + " " + sb);
        System.out.println("최종비용 : " + cost);


    }

    public static void init() {
        graph.clear();
        cost = 0;
        sb.setLength(0);
    }

    public static void prim(int p) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(p);

        while (!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            for (Node n : nodeList[node]) {
                if (!visited[n.end]) {
                    pq.add(n);
                }
            }
            while (!pq.isEmpty()) {
                Node e = pq.poll();
                if (!visited[e.end]) {
                    q.add(e.end);
                    visited[e.end] = true;
                    sb.append(String.valueOf((char) (e.end + 65)) + " ");
                    // StringBuilder 사용 각 나옴
                    cost += e.cost;
                    break;
                }
            }
        }


    }
}
