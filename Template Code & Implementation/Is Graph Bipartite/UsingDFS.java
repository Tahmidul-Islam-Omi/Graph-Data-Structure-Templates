class Solution
{
    public boolean Bipartite(int node , int col , ArrayList<ArrayList<Integer>> adj , int[] colorArr) {

        colorArr[node]  = col;

        for(int it : adj.get(node)) {
            if( colorArr[it] == -1) {
                if(!Bipartite(it, 1 - col, adj, colorArr)) {
                    return false;
                }
            }

            if( colorArr[it] == colorArr[node] ) {
                return false;
            }
        }

        return true;

    }


    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int [] colorArr = new int[V];
        Arrays.fill(colorArr,-1);

        for(int i=0 ;i<V; i++) {
            if(colorArr[i] == -1) {
                if( !Bipartite(i , 1  , adj  ,colorArr) ) {
                    return false;
                }
            }
        }

        return true;


    }
}