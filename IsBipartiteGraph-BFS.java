class Solution
{
    
    private boolean bfs(int start, Boolean colour[], ArrayList<ArrayList<Integer>>adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colour[start] = true;
        while(!queue.isEmpty()) {
            int node = queue.remove();
            Boolean nodeColor = colour[node];
            for (Integer adjNode : adj.get(node)) {
                if (colour[adjNode] == null) {
                    colour[adjNode] = !nodeColor;
                    queue.add(adjNode);
                }
                else if (colour[adjNode] == nodeColor) return false;
                
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Boolean colour[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            if (colour[i] == null) {
                if (!bfs(i, colour, adj)) {
                    return false;
                }
            }
            
        }
        
        return true;
        
    }
}
