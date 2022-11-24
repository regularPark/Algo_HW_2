import Algorithm.GraphTraveral.*;
import Algorithm.MST.*;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BFS bfs = new BFS();
        bfs.search();

        DFS dfs = new DFS();
        dfs.search();

        Kruskal kruskal = new Kruskal();
        kruskal.search();

        Prim prim = new Prim();
        prim.search();

    }
}
