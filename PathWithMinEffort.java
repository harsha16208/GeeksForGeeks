class Solution {
    
    class Data {
        int row;
        int col;
        int diff;
        
        public Data(int row, int col, int diff) {
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
    }
    
    int MinimumEffort(int heights[][]) {
        
        int n = heights.length;
        int m = heights[0].length;
        int diff[][] = new int[n][m];
        
        
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = (int)1e9;
            }
        }
        diff[0][0] = 0;
        
        PriorityQueue<Data> queue = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        queue.add(new Data(0, 0, 0));
        
        while(!queue.isEmpty()) {
            Data data = queue.remove();
            int row = data.row;
            int col = data.col;
            int diffr = data.diff;
            
            if (row == n - 1 && col == m - 1) {
                return diffr;
            }
            
            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, -1, 0, 1};
            
            for (int i = 0; i < delRow.length; i++) {
                int nRow = delRow[i] + row;
                int nCol = delCol[i] + col;
                if (nRow >=0 && nRow < n && nCol >= 0 && nCol < m) {
                    int newDiff = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]), diffr);
                    if (newDiff < diff[nRow][nCol]) {
                        diff[nRow][nCol] = newDiff;
                        queue.add(new Data(nRow, nCol, newDiff));
                    }
                }
            }
            
        }
        
        return -1;
    }
}
