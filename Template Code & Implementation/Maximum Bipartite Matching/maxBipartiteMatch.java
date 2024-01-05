// Example is described as job candidate vs jobs
// GFG Probelem Link:- https://www.geeksforgeeks.org/problems/maximum-bipartite-matching/1

class Solution
{
    public boolean maxMatch(int[][] G, int[] jobsAssign, int u, boolean[] seen) {
        int jobs = G[0].length;

        for (int v = 0; v < jobs; v++) {
            if (G[u][v] == 1 && !seen[v]) {
                seen[v] = true;

                if (jobsAssign[v] == -1 || maxMatch(G, jobsAssign, jobsAssign[v], seen)) {
                    jobsAssign[v] = u;
                    return true;
                }
            }
        }

        return false;
    }
    
    public int maximumMatch(int[][] G)
    {
        // Code here
        int people = G.length;
        int jobs = G[0].length;

        int[] jobsAssign = new int[jobs];
        Arrays.fill(jobsAssign, -1);

        int result = 0;

        for (int i = 0; i < people; i++) {
            boolean[] seen = new boolean[jobs];
            Arrays.fill(seen, false);

            if (maxMatch(G, jobsAssign, i, seen)) {
                result++;
            }
        }

        return result;
        
    }
}