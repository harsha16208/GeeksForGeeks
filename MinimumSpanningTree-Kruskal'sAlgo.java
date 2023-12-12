class DisjointSet {
    int parent[];
    int size[];
    
    public DisjointSet(int size) {
        this.parent = new int[size];
        this.size = new int[size];
        for (int i =0; i < size; i++) parent[i] = i;
        Arrays.fill(this.size, 1);
    }
    
    public int findUltimateParent(int node) {
        if (parent[node] == node) {
            return parent[node];
        } 
        return parent[node] = findUltimateParent(parent[node]);
    }
    
    public void unionBySize(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);
        
        if (pu == pv) return;
        
        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else { // if pv size is greater than pu size
            parent[pu] = pv;
            size[pv] += pu;
        }
    }
}


class Edge {
    int src;
    int dest;
    int weight;
    
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    List<Edge> edgesL = new ArrayList<>();
	    
	    for (int i = 0; i < edges.length; i++) {
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int w = edges[i][2];
	        edgesL.add(new Edge(u, v, w));
	    }
	    
	    edgesL.sort((edge1, edge2) -> edge1.weight - edge2.weight);
	    
	    DisjointSet ds = new DisjointSet(V);
	    int mst = 0;
	    
	    for (Edge edge : edgesL) {
	        int u = edge.src;
	        int v = edge.dest;
	        int w = edge.weight;
	        
	        if (ds.findUltimateParent(u) != ds.findUltimateParent(v)) {
	            ds.unionBySize(u, v);
	            mst+=w;
	        }
	    }
	    return mst;
	}
}
