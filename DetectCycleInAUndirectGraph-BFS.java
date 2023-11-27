class Pair {
    int src;
    int parent;
    
    public Pair(int src, int parent) {
        this.src = src;
        this.parent = parent;
    }
}


class Solution {
    
    private boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));
        vis[src] = true;
        
        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            for (Integer adjNode : adj.get(pair.src)) {
                if (!vis[adjNode]) {
                    queue.add(new Pair(adjNode, pair.src));
                    vis[adjNode] = true;
                } else if (pair.parent != adjNode) {
                    return true;
                }
            }
        }
        return false;
        
        
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!vis[i]) {
                if (detectCycle(i, adj, vis)) {
                return true;
                }
            }
        }
        
        return false;
    }
}
