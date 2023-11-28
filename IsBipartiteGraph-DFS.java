class Solution
{
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, Boolean[] colors, Boolean color) {
        colors[node] = color;
        
        for (Integer adjNode : adj.get(node)) {
            if (colors[adjNode] == null) {
                if(!dfs(adjNode, adj, colors, !colors[node])) {
                    return false;
                }
            } else if (colors[adjNode] == color) {
                return false;
            }
        }
        
        return true;
    }
    
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Boolean[] color = new Boolean[V];
        for (int i = 0; i < V; i++) {
            if (color[i] == null)
            {
                if (!dfs(i, adj, color, true)) return false;
            }
            
        }
        return true;
    }
}
