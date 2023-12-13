class Solution
{
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[node] = true;

        for (Integer adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                dfs(adjNode, adj, vis, stack);
            }
        }
        
        stack.push(node);
    }
    
    private void dfsR(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        
        for (Integer adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                dfsR(adjNode, adj, vis);
            }
        }
    }
    
    
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        // Step-1 Perform sorting of edges
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, stack);
            }
        }
        
        // Step-2 Reverse Graph
        ArrayList<ArrayList<Integer>> adjR = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjR.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++) {
            vis[i] = false;
            for (Integer adjNode : adj.get(i)) {
                adjR.get(adjNode).add(i);
            }
        }
        
        // step-3 Dfs on reversed graph
        int count = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            
            if (!vis[node]) {
                count++;
                dfsR(node, adjR, vis);
            }
        }
        
        return count;
        
        
    }
}
