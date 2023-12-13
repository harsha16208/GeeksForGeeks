class DisjointSet {
    int parent[];
    int size[];
    
    public DisjointSet(int size) {
        this.parent = new int[size + 1];
        for (int i = 0; i <= size; i++) parent[i] = i;
        this.size = new int[size + 1];
        Arrays.fill(this.size, 1);
    }
    
    public int findUltimateParent(int node) {
        if (node == parent[node]) {
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

    int maxRemove(int[][] stones, int n) {
        // Code here
        
        int maxRow = 0;
        int maxCol = 0;
        
        for (int i = 0; i < n; i++) {
            maxRow  = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Map<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int rowIdx = stones[i][0];
            int colIdx = stones[i][1] + maxRow + 1;
            
            ds.unionBySize(rowIdx, colIdx);
            stoneNodes.put(rowIdx, 1);
            stoneNodes.put(colIdx, 1);
        }
        
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : stoneNodes.entrySet()) {
            if (ds.findUltimateParent(ds.parent[entry.getKey()]) == entry.getKey()) count++;
        }
        
        return n - count;
    }
};

