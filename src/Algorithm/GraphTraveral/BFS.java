package Algorithm.GraphTraveral;

import java.util.*;
import java.io.*;

public class BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Graph1.txt"));
        ArrayList<String[]> graph_arr = new ArrayList<>();
        LinkedList<String> graph = new LinkedList<>();

        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            graph_arr.add(s);
        }
        boolean [] visited = new boolean[graph_arr.size()];

        for (String[] c : graph_arr){
            System.out.println(Arrays.toString(c));
        }

    }
}
