class Data {
    int row;
    int col;
    int time;
    
    public Data(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        int visited[][] = new int[m][n];
        Queue<Data> queue = new LinkedList<>();
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Data(i, j, 0));
                    visited[i][j] = 2;
                }
            }
        }
        
        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, -1, 0, 1};
        int time = 0;
        
        while (!queue.isEmpty()) {
            Data data = queue.remove();
            time = Math.max(time, data.time);
            for (int i=0; i<dRow.length; i++) {
                int nRow = data.row + dRow[i];
                int nCol = data.col + dCol[i];
                if (nRow >=0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0) {
                    queue.add(new Data(nRow, nCol, data.time + 1));
                    visited[nRow][nCol] = 2;
                    
                }
            }
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] != 2 && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return time;
        
    }
}
