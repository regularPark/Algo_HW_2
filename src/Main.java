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

//        BFS bfs = new BFS();
//        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
//            System.out.print("#" + i + " ");
//            bfs.search(start, "Graph" + i + ".txt");
//        }
//
//        System.out.println();
//
//        DFS dfs = new DFS();
//        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
//            System.out.print("#" + i + " ");
//            dfs.search(start, "Graph" + i + ".txt");
//        }
//
//        System.out.println();
//
//        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
//            Kruskal kruskal = new Kruskal();
//            System.out.print("#" + i + " ");
//            kruskal.search("Graph" + i + ".txt");
//            kruskal.init();
//        }
//
//        System.out.println();
//
//        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
//            Prim prim = new Prim();
//            System.out.print("#" + i + " ");
//            prim.search(start, "Graph" + i + ".txt");
//            prim.init();
//        }

//        System.out.println();


//        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
//            Sollin sollin = new Sollin();
//            System.out.print("#" + i + " ");
//            sollin.search("Graph" + i + ".txt");
//            sollin.init();
//        }
        System.out.println();
        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
            System.out.print("#" + i + " ");
            Dijkstra dijkstra = new Dijkstra();
            dijkstra.search(start, "Graph" + i + ".txt");
            dijkstra.init();
        }
        System.out.println();
        for (int i = 1; i <= NUM_OF_GRAPH; i++) {
            System.out.println("#" + i + " Floyd-Warshall");
            Floyd_Warshall floyd_warshall = new Floyd_Warshall();
            floyd_warshall.search("Graph" + i + ".txt");
//            floyd_warshall.init();
        }
    }
}
