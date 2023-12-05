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
       TreeSet<Node> set = new TreeSet<>((node1, node2) -> {
            if (node1.value != node2.value && node1.dist == node2.dist){
                return 1;
            }
            return node1.dist - node2.dist;
        });
        set.add(new Node(S, 0));
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = (int)1e9;
        }
        dist[S] = 0;

        while (!set.isEmpty()) {
            Node node = set.pollFirst();

            for (ArrayList<Integer> adjNodes : adj.get(node.value)) {
                int adjNode = adjNodes.get(0);
                int adjNodeDist = adjNodes.get(1);

                if (dist[node.value] + adjNodeDist < dist[adjNode]) {
                    set.add(new Node(adjNode, dist[node.value] + adjNodeDist));
                    dist[adjNode] = dist[node.value] + adjNodeDist;
                }

            }
        }

        return dist;
    }
}
