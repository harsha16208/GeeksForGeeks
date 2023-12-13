class DisjointSet {
    int parent[];
    int size[];
    
    public DisjointSet(int size) {
        this.parent = new int[size];
        for (int i = 0;  i < size; i++) parent[i] = i;
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
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int[][] vis = new int[rows][cols];
        int k = operators.length;
        List<Integer> res = new ArrayList<>();
        
        DisjointSet ds = new DisjointSet(rows * cols);
        int islands = 0;
        for (int i = 0; i < k; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            
            if (vis[row][col] == 0) {
                vis[row][col] = 1;
                islands++;
                
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                
                for (int j = 0; j < dr.length; j++) {
                    int adjRow = row + dr[j];
                    int adjCol = col + dc[j];
                    
                    if (adjRow >= 0 && adjRow < rows && adjCol >= 0 && adjCol < cols) {
                        if (vis[adjRow][adjCol] == 1) {
                            int nodeIdx = row * cols + col;
                            int adjNodeIdx = adjRow * cols + adjCol;
                            if (ds.findUltimateParent(nodeIdx) != ds.findUltimateParent(adjNodeIdx)) {
                                islands--;
                                ds.unionBySize(nodeIdx, adjNodeIdx);
                            }
                            
                        }
                    }
                }
            }
            
            res.add(islands);
            
        }
        return res;
    }
    
}
