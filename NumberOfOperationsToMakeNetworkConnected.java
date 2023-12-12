class DisjointSet {
    int parent[];
    int size[];
    
    public DisjointSet(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
        this.size = new int[size];
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
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}

class Solution {

    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            
            if (ds.findUltimateParent(u) == ds.findUltimateParent(v)) {
                extraEdges++;
            } else {
                ds.unionBySize(u, v);
            }
        }
        
        int comp = 0;
        
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i) comp++;
        }
        
        int ans = comp - 1;
        
        if (extraEdges >= ans) {
            return ans;
        }
        return -1;
    }
}
