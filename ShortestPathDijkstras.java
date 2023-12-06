class Solution{
    
    class Node {
        int val;
        int weight;
        
        public Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }
    
    public List<Integer> shortestPath(int n, int m, int edges[][]){
        //  Code Here.
        
        int[] parent = new int[n + 1];
        int[] dist = new int[n + 1];
        List<Integer> res = new ArrayList<>();
        List<List<List<Integer>>> adj = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> node1.weight - node2.weight);
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i< m; i++) {
            
            int u = edges[i][0]; //vertex
            int v = edges[i][1]; //vertex
            int w = edges[i][2]; //weight
            
            List<Integer> list1 = new ArrayList<>();
            list1.add(v);
            list1.add(w);
            
            List<Integer> list2 = new ArrayList<>();
            list2.add(u);
            list2.add(w);
            
            adj.get(u).add(list1);
            adj.get(v).add(list2);

        }
        
        queue.add(new Node(1, 0));
        parent[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dist[i] = (int)1e9;
        }
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (List<Integer> adjNode : adj.get(node.val)) {
                if (dist[node.val] + adjNode.get(1) < dist[adjNode.get(0)]) {
                    queue.add(
                        new Node(adjNode.get(0),
                        dist[node.val] + adjNode.get(1)));
                    dist[adjNode.get(0)] = dist[node.val] + adjNode.get(1);
                    parent[adjNode.get(0)] = node.val;
                    
                }
            }
        }
        
        int cursor = n;
        
        res.add(n);
        while (parent[cursor] != cursor) {
            res.add(parent[cursor]);
            cursor = parent[cursor];
        }
        
        Collections.reverse(res);
        
        return res;
    }
}
