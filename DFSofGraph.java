class Solution {
    
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> res) {
        res.add(node);
        visited[node] = true;
        for (Integer i : adj.get(node)) {
            if (!visited[i]) {
                dfs(i, adj, visited, res);
            }
        }
    }
    
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        int startNode = 0;
        boolean[] visited = new boolean[V];
        dfs(startNode, adj, visited, res);
        return res;
    }
}
