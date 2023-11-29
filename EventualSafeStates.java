class Solution {
    
    
    boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis, boolean[] check) {
        vis[node] = true;
        pathVis[node] = true;
        
        for (Integer adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, adj, vis, pathVis, check)) return true;
            } else if (pathVis[adjNode]) {
                return true;
            }
        }
        
        check[node] = true;
        pathVis[node] = false;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, pathVis, check);
            }
        }
        
        for (int i=0; i<V; i++) {
            if (check[i]) {
                res.add(i);
            }
        }
        
        return res;
    }
}
