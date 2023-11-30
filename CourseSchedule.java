class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> pair = prerequisites.get(i);
            adj.get(pair.get(1)).add(pair.get(0));
        }
        
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int adjNode : adj.get(i)) {
                indegree[adjNode]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int[] res = new int[n];
        int cursor = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            res[cursor] = node;
            cursor++;
            
            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }
        
        if (cursor == n) return res;
        int []empty = {};
        return empty;
        
    }
}
