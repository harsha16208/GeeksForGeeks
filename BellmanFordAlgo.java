class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int)1e8;
        dist[S] = 0;
        
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> list : edges) {
                int u = list.get(0);
                int v = list.get(1);
                int w = list.get(2);
                
                if (dist[u] != 1e8 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        
        for (ArrayList<Integer> list : edges) {
            int u = list.get(0);
            int v = list.get(1);
            int w = list.get(2);
            
            if (dist[u] != 1e8 &&dist[u] + w < dist[v]) {
                return new int[]{-1};
            }
        }
        
        return dist;
    }
}
