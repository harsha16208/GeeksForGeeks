class Solution {
    
    class Pair {
        int row;
        int col;
        int dist;
        
        public Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int n = grid.length; //row-length
        int m = grid[0].length; //col-length
        boolean[][] vis = new boolean[n][m];
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source[0], source[1], 0));
        vis[source[0]][source[1]] = true;
        
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            
            if (pair.row == destination[0] && pair.col == destination[1]) {
                return pair.dist;
            }
            
            int[] delRow = {-1, 0, 1, 0};
            int[] delCol = {0, -1, 0, 1};
            
            for (int i = 0; i < delRow.length; i++) {
                int nRow = delRow[i] + pair.row;
                int nCol = delCol[i] + pair.col;
                int nDist = pair.dist + 1;
                
                if (nRow >=0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol] && grid[nRow][nCol] != 0) {
                    vis[nRow][nCol] = true;
                    queue.add(new Pair(nRow, nCol, nDist));
                }
            }
            
        }
        
        return -1;
    }
}
