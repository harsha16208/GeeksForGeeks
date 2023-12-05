class Solution
{
    static class Node {
        int value;
        int dist;
        
        public Node(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }
    }
    
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int)1e9;
        }
        
        dist[S] = 0;
        
        PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> node1.dist - node2.dist);
        queue.add(new Node(S, 0));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (ArrayList<Integer> adjNodes : adj.get(node.value)) {
                int adjNode = adjNodes.get(0);
                int adjNodeDist = adjNodes.get(1);
                
                if (dist[adjNode] > dist[node.value] + adjNodeDist) {
                    queue.add(new Node(adjNode, dist[node.value] + adjNodeDist));
                    dist[adjNode] = dist[node.value] + adjNodeDist;
                }
            }
        }
        
        return dist;
    }
}

