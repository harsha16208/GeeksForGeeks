class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[V];
        visited[0] = true;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        
        while(!queue.isEmpty()) {
            int node = queue.remove();
            for (Integer i : adj.get(node)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    res.add(i); 
                }
                
            }
        }
        
        return res;
    }
}
