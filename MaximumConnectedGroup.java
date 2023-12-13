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
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}


class Solution {
    
    public int MaxConnection(int grid[][]) {
        //Your code here
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;
                
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                
                //Step-1 connecting the components on a disjoint set
                for (int del = 0; del < dr.length; del++) {
                    int adjRow = row + dr[del];
                    int adjCol = col + dc[del];
                    
                    if (adjRow >=0 && adjRow < n && adjCol >= 0 && adjCol < n) {
                        if (grid[adjRow][adjCol] == 1) {
                            // indexes to plot on disjoint set
                            int nodeIdx = row * n + col;
                            int adjNodeIdx = adjRow * n + adjCol;
                            
                            if (ds.findUltimateParent(nodeIdx) != ds.findUltimateParent(adjNodeIdx)) {
                                ds.unionBySize(nodeIdx, adjNodeIdx);
                            }
                        }
                    }
                }
            }
        }
                
        // step-2 : counting max size of an island at every zero
        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    Set<Integer> parents = new HashSet<Integer>();
                    int dr[] = {-1, 0, 1, 0};
                    int dc[] = {0, -1, 0, 1};
                    
                    for (int i = 0; i < dr.length; i++) {
                        int adjRow = row + dr[i];
                        int adjCol = col + dc[i];
                        
                        if (adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n) {
                            if (grid[adjRow][adjCol] == 1) {
                                int nodeIdx = adjRow * n + adjCol;
                                int parent = ds.findUltimateParent(nodeIdx);
                                parents.add(parent);
                            }
                        }
                    }
                    
                    int val = 1;
                    for (Integer parent :  parents) {
                        val += ds.size[parent];
                    }
                    max = Math.max(max, val);
                }
            }
        }
        
        for (int i = 0; i < n * n; i++) {
            max = Math.max(max, ds.size[ds.findUltimateParent(i)]);
        }
                
                return max;
    }
    
}
