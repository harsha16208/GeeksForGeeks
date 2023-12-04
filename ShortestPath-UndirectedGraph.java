class Solution {
    
    class Node {
        int value;
        int dist;
        
        public Node(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }
    }
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] dist = new int[n];
        
        for (int i = 0; i < n; i++) {
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(src, 0));
        
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            
            for (int adjNode : adj.get(node.value)) {
                if (node.dist + 1 < dist[adjNode]) {
                    dist[adjNode] = node.dist + 1;
                    queue.add(new Node(adjNode, node.dist + 1));
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int)1e9) {
                dist[i] = -1;
            }
        }
        
        return dist;
        
    }
}
