package code.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartition {
    public boolean isBipartite(int[][] graph) {
        int vCount = graph.length;
        int[] color = new int[vCount];

        Arrays.fill(color, -1);
        for (int i=0; i<vCount; i++){
            if (color[i] == -1){
                if (!bfs(i, color, graph)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int source, int[] color, int[][] graph){

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(source);
        color[source] = 1;

        while (!q.isEmpty()){
            int node = q.poll();
            for (int neighbor : graph[node]){
                if (color[neighbor] == -1){
                    if (color[node] == 0){
                        color[neighbor] = 1;
                    } else {
                        color[neighbor] = 0;
                    }
                    q.add(neighbor);
                } else {
                    if (color[neighbor] == color[node])
                        return false;
                }

            }
        }
        return true;
    }

    public static void main(String [] args){
        Bipartition bip = new Bipartition();
        int[][] graph = new int[][] {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println("Bipartition graph([[1,2,3],[0,2],[0,1,3],[0,2]]): " + bip.isBipartite(graph));

        graph = new int[][] {{1,3},{0,2},{1,3},{0,2}};
        System.out.println("Bipartition graph ([[1,3],[0,2],[1,3],[0,2]]): " + bip.isBipartite(graph));

    }
}
