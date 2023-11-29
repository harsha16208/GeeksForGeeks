class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        
        for (int i = 0; i < V; i++) {
            for (Integer adjNode : adj.get(i)) {
                indegree[adjNode]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int count=0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            count++;
            
            for (Integer adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) queue.add(adjNode);
            }
        }
        
        return count == V ? false : true;
    }
}
