class Solution {
    
    private boolean detectCycle(int src, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        
        for (Integer adjNode : adj.get(src)) {
            if (!vis[adjNode]) {
                 if(detectCycle(adjNode, src, vis, adj)) {
                     return true;
                 }
            } else if (parent != adjNode) {
                return true;
            }
        }
        
        return false;
        
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!vis[i]) {
               if (detectCycle(i, -1, vis, adj)) {
                    return true;
                } 
            }
            
        }
        
        return false;
    }
}
