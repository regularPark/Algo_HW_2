import Algorithm.GraphTraveral.*;
import Algorithm.MST.*;
import Algorithm.ShotestPath.Dijkstra;
import Algorithm.ShotestPath.Floyd_Warshall;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    static int NUM_OF_GRAPH = 6;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int start = 0;
        while (true) {
            try {
                System.out.print("출발점 입력 >> ");
                String str_start = scanner.next();
                char char_start = str_start.charAt(0);
                start = (int) char_start - 65;

                if (start < 0 || start > 26) {
                    throw new Exception();
                }
                break;
            } catch (Exception error) {
                System.out.println("A ~ Z 재입력하시오");
            }
        }

        BFS bfs = new BFS();
        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
            long start_bfs = System.currentTimeMillis();

            System.out.print("#" + i + " ");
            bfs.search(start, "Graph" + i + ".txt");

            long end_bfs = System.currentTimeMillis();
            System.out.println("BFS 수행 시간 : " + (end_bfs - start_bfs) / 1000.0 + "\n");
        }

        System.out.println();

        DFS dfs = new DFS();
        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
            long start_dfs = System.currentTimeMillis();

            System.out.print("#" + i + " ");
            dfs.search(start, "Graph" + i + ".txt");

            long end_dfs = System.currentTimeMillis();
            System.out.println("DFS 수행 시간 : " + (end_dfs - start_dfs) / 1000.0 + "\n");
        }

        System.out.println();

        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
            long start_kruskal = System.currentTimeMillis();

            Kruskal kruskal = new Kruskal();
            System.out.print("#" + i + " Kruskal : ");
            kruskal.search("Graph" + i + ".txt");

            long end_kruskal = System.currentTimeMillis();
            System.out.println("Kruskal 수행 시간 : " + (end_kruskal - start_kruskal) / 1000.0 + "\n");
            kruskal.init();
        }

        System.out.println();

        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
            long start_prim = System.currentTimeMillis();

            Prim prim = new Prim();
            System.out.print("#" + i + " Prim : ");
            prim.search(start, "Graph" + i + ".txt");

            long end_prim = System.currentTimeMillis();
            System.out.println("Prim 수행 시간 : " + (end_prim - start_prim) / 1000.0 + "\n");
            prim.init();
        }

        System.out.println();


        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
            long start_sollin = System.currentTimeMillis();

            Sollin sollin = new Sollin();
            System.out.print("#" + i + " Sollin : ");
            sollin.search("Graph" + i + ".txt");

            long end_sollin = System.currentTimeMillis();
            System.out.println("Sollin 수행 시간 : " + (end_sollin - start_sollin) / 1000.0 + "\n");
            sollin.init();
        }
        System.out.println();
        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
            long start_dijkstra = System.currentTimeMillis();

            System.out.print("#" + i + " Dijkstra : ");
            Dijkstra dijkstra = new Dijkstra();
            dijkstra.search(start, "Graph" + i + ".txt");

            long end_dijkstra = System.currentTimeMillis();
            System.out.println("Dijkstra 수행 시간 : " + (end_dijkstra - start_dijkstra) / 1000.0 + "\n");
            dijkstra.init();
        }
        System.out.println();
        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
            long start_floyd = System.currentTimeMillis();

            System.out.println("#" + i + " Floyd-Warshall");
            Floyd_Warshall floyd_warshall = new Floyd_Warshall();
            floyd_warshall.search(start, "Graph" + i + ".txt");

            long end_floyd = System.currentTimeMillis();
            System.out.println("Floyd-Warshall 수행 시간 : " + (end_floyd - start_floyd) / 1000.0 + "\n");
        }
    }
}
