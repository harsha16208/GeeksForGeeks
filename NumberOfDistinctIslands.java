class Solution {
    
    class Pair {
        int row;
        int col;
        
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        public String toString() {
            return this.row + " " + this.col;
        }
    }
    
    
    private void dfs(int row, int col, boolean[][] vis, int[][] grid, int bRow, int bCol, List<String> list) {
        vis[row][col] = true;
        list.add(new Pair(row - bRow, col - bCol).toString());
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < delRow.length; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && !vis[nRow][nCol]) {
                dfs(nRow, nCol, vis, grid, bRow, bCol, list);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<List<String>> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    dfs(i, j, vis, grid, i, j, list);
                    set.add(list);
                }
            }
        }
        
        
        return set.size();
    }
}
