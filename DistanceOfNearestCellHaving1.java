class Solution
{
    class Data {
        int row;
        int col;
        int dist;
        
        public Data (int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    
    
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        Queue<Data> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int res[][] = new int[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Data(i, j, 0));
                }
            }
        }
        
        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, -1, 0, 1};
        
        while(!queue.isEmpty()) {
            Data data = queue.remove();
            res[data.row][data.col] = data.dist;
            for (int i=0; i<dRow.length; i++) {
                int nRow = data.row + dRow[i];
                int nCol = data.col + dCol[i];
                
                if (nRow >=0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 0 && !vis[nRow][nCol]) {
                    queue.add(new Data(nRow, nCol, data.dist + 1));
                    vis[nRow][nCol] = true;
                }
                
            }
        }
        
        return res;
        
    }
}
