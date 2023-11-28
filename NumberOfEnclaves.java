class Solution {
    
    
    class Data {
        int row;
        int col;
        
        public Data(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        Queue<Data> queue = new LinkedList<>();
        
        //Finding 1's at boundaries
        // 1. Checking for 1's in 1st col and last col
        
        for (int i=0; i<n; i++) {
            if (grid[i][0] == 1) {
                queue.add(new Data(i, 0));
            }
            
            if (grid[i][m-1] == 1) {
                queue.add(new Data(i, m-1));
            }
        }
        
        // 2. Checking for 1's in 1st row and last row
        
        for (int i=0; i<m; i++) {
            if (grid[0][i] == 1) {
                queue.add(new Data(0, i));
            }
            
            if (grid[n-1][i] == 1) {
                queue.add(new Data(n-1, i));
            }
        }
        
        while(!queue.isEmpty()) {
            Data data = queue.remove();
            vis[data.row][data.col] = true;
            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, -1, 0, 1};
            
            for (int i=0; i<delRow.length; i++) {
                int nRow = data.row + delRow[i];
                int nCol = data.col + delCol[i];
                
                if (nRow >=0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && !vis[nRow][nCol]) {
                    queue.add(new Data(nRow, nCol));
                }
            }
        }
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        
        return count;
        
    }
}
