// GFG Problem Link - https://www.geeksforgeeks.org/problems/find-the-maximum-flow2126/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class maxFlow {

    public static int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) {

        int[][] rGraph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            rGraph[Edges.get(i).get(0)][Edges.get(i).get(1)] += Edges.get(i).get(2);
            rGraph[Edges.get(i).get(1)][Edges.get(i).get(0)] += Edges.get(i).get(2);
        }

        // for undirected graph
        // using += for input like - 1,5,3 ; 5,1,3


        int[] parent = new int[N + 1];

        int maxFlow = 0;

        int src = 1;

        while (bfs(rGraph, parent,  N)) {

            int path_flow = Integer.MAX_VALUE;

            int v = N;

            while (v != 1) {
                int u = parent[v];

                path_flow = Math.min(path_flow, rGraph[u][v]);

                v = u;
            }

            v = N;

            while (v != 1) {

                int u = parent[v];

                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;

                v = u;
            }

            maxFlow += path_flow;

        }

        return maxFlow;
    }

    private static boolean bfs(int[][] rGraph, int[] parent, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        parent[1] = -1;

        boolean[] visited = new boolean[N + 1];
        Arrays.fill(visited, false);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int u = queue.peek();
            queue.poll();

            for (int v = 1; v <= N; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    if (v == N) {
                        parent[v] = u;
                        return true;
                    }

                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 1)),
                        new ArrayList<>(Arrays.asList(3, 2, 2)),
                        new ArrayList<>(Arrays.asList(4, 2, 3)),
                        new ArrayList<>(Arrays.asList(2, 5, 5))
                )
        );

        System.out.println(GFG.findMaxFlow(5, 4, edges));
    }

}
