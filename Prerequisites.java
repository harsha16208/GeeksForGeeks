class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < P; i++) {
            int[] pair = prerequisites[i];
            adj.get(pair[0]).add(pair[1]);
        }
        
        int[] indegree = new int[N];
        
        for (int i = 0;  i < N; i++) {
            for (int adjNode : adj.get(i)) {
                indegree[adjNode]++;
            }
        }
        
        Queue<Integer> queue= new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.remove();
            count++;
            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }
        
        return count == N ? true : false;
        
    }
    
}
