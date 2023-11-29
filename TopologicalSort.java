class Solution
{
    
    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        vis[node] = true;
        
        for (Integer adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                dfs(adjNode, vis, adj, stack);
            }
        }
        
        stack.push(node);
    }
    
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, stack);
            }
        }
        
        int cursor = 0;
        while(!stack.isEmpty()) {
            res[cursor] = stack.pop();
            cursor++;
        }
        
        return res;
    }
}
