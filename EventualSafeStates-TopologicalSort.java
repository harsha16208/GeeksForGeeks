class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        
        int indegree[] = new int[V];
        
        for (int i = 0; i < V; i++) {
            for (Integer adjNode : adj.get(i)) {
                revAdj.get(adjNode).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.remove();
            res.add(node);
            
            for (int adjNode : revAdj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }
        
        Collections.sort(res);
        
        return res;
        
        
        
    }
}
