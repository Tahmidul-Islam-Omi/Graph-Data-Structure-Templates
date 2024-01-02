class Solution
{
    public boolean Bipartite(int V , int src , ArrayList<ArrayList<Integer>> adj , int[] colorArr) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(src);

        colorArr[src] = 1;

        while ( ! queue.isEmpty()) {
            int u = queue.peek();
            queue.poll();

            for(int i = 0; i < adj.get(u).size(); i++) {
                
                int v = adj.get(u).get(i);

                if(u == v) {
                    return false; // self-loop
                }

                if( colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    queue.add(v);
                }

                else if( colorArr[u] == colorArr[v]) {
                    return false;
                }
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
                if( !Bipartite(V , i , adj  ,colorArr) ) {
                    return false;
                }
            }
        }

        return true;


    }
}