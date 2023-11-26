class Solution
{
    
    private void dfs(int row, int col, int[][] image, int[][] res, int newColor, int initColor) {
        res[row][col] = newColor;
        int delRows[] = {-1, 0, 1, 0};
        int delCols[] = {0, -1, 0, 1};
        int m = image.length;
        int n = image[0].length;
        
        for (int i = 0; i<delRows.length; i++) {
            int nRow = delRows[i] + row;
            int nCol = delCols[i] + col;
            
            if (nRow >=0 && nRow < m && nCol >=0 && nCol < n && res[nRow][nCol] == initColor
            && res[nRow][nCol] != newColor
            ) {
                dfs(nRow, nCol, image, res, newColor, initColor);
            }
        }
    }
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        //copy image
        int m = image.length;
        int n = image[0].length;
        int[][] res = new int[m][n];
        int initColor = image[sr][sc];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                res[i][j] = image[i][j];
            }
        }
        
        dfs(sr, sc, image, res, newColor, initColor);
        
        return res;
        
        
        
    }
}
