class Data {
    int node;
    int parent;
    int weight;
    
    public Data (int node, int parent, int weight) {
        this.node = node;
        this.parent = parent;
        this.weight = weight;
    }
}

class Pair {
    int first;
    int second;
    
    public Pair (int first, int second) {
        this.first = first;
        this.second = second;
    }
}


class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    PriorityQueue<Data> queue = new PriorityQueue<>((node1, node2) -> node1.weight - node2.weight);
	    boolean[] vis = new boolean[V];
	    
	    List<List<Pair>> adj = new ArrayList<>();
	    
	    for (int i = 0; i < V; i++) {
	        adj.add(new ArrayList<>());
	    }
	    
	    for (int i = 0; i < E; i++) {
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int w = edges[i][2];
	        adj.get(u).add(new Pair(v, w));
	        adj.get(v).add(new Pair(u, w));
	    }
	    
	    queue.add(new Data(0, -1, 0));
	    List<Pair> mst = new ArrayList<>();
	    int sum = 0;
	    while (!queue.isEmpty()) {
	        Data data = queue.remove();
	        if (vis[data.node]) continue;
	        vis[data.node] = true;
	        if (data.parent != -1) mst.add(new Pair(data.parent, data.node));
	        sum += data.weight;
	        
	        for (Pair adjNode : adj.get(data.node)) {
	            int node = adjNode.first;
	            int ew = adjNode.second; // ew -> edge weight
	            if (!vis[node]) {
	                queue.add(new Data(node, data.parent, ew));
	            }
	        }
	    }
	    
	    return sum;
	    
	}
}
