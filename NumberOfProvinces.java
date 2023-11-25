class Solution {
    
    private static void dfs(int startNode, boolean visited[], List<List<Integer>> adj) {
        visited[startNode] = true;
        for (Integer i : adj.get(startNode)) {
            if(!visited[i]) {
                dfs(i, visited, adj);
            }
        }
        
    }
    
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        // Converting Adjacency matric into an adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i=0; i<V; i++) {
            adjList.add(new ArrayList());
        }
        
        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                if(adj.get(i).get(j) == 1 && i!=j) {
                    adjList.get(i).add(j); // Adding vertices to which it has an edge
                }
            }
        } // End of converting adjacency matrix into a list
        
        
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i=0; i<V; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, visited, adjList);
            }
        }
        
        return count;
        
    }
};
