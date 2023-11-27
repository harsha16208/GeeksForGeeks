class Solution{
    
    private static void dfs(int row, int col, char a[][], boolean[][] vis) {
        vis[row][col] = true;
        int m = vis.length;
        int n = vis[0].length;
        
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};
        
        for (int i=0; i<delRow.length; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if (nRow >=0 && nRow < m && nCol >= 0 && nCol < n && !vis[nRow][nCol] && a[nRow][nCol] == 'O') {
                dfs(nRow, nCol, a, vis);
            }
        }
    }
    
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean[][] vis = new boolean[n][m];
        
        //Finding O in first row and last row
        for (int j=0; j<m; j++) {
            if (a[0][j] == 'O') {
                if (!vis[0][j])
                    dfs(0, j, a, vis);
            }
            
            if (a[n-1][j] == 'O') {
                if (!vis[n-1][j])
                    dfs(n-1, j, a, vis);
            }
        }
        
        //Finding O in first col and last col
        for (int i=0; i<n; i++) {
            if (a[i][0] == 'O') {
                if (!vis[i][0])
                    dfs(i, 0, a, vis);
            }
            
            if (a[i][m-1] == 'O') {
                if (!vis[i][m-1])
                    dfs(i, m-1, a, vis);
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!vis[i][j] && a[i][j] == 'O') {
                    a[i][j] = 'X';
                }
            }
        }
        
        return a;
    }
}
