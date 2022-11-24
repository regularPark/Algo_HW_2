import Algorithm.GraphTraveral.*;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BFS bfs = new BFS();
        bfs.search();

        DFS dfs = new DFS();
        dfs.search();

    }
}
