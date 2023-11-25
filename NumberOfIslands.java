class Pair {
    int first;
    int second;
    
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


class Solution {
    
    
    private void bfs(boolean[][] visited, char[][] grid, int row, int col) {
        visited[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int m = grid.length;
        int n = grid[0].length;
        
        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            
            for (int i=-1; i<=1; i++) {
                for (int j=-1; j<=1; j++) {
                    int nRow = pair.first + i;
                    int nCol = pair.second + j;
                    if (nRow >=0 && nRow < m && nCol >=0 && nCol < n && grid[nRow][nCol] == '1' &&
                    !visited[nRow][nCol]) {
                        visited[nRow][nCol] = true;
                        queue.add(new Pair(nRow,nCol));
                    }
                }
            }
        }
    }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(visited, grid, i, j);
                }
                
            }
        }
        return count;
    }
}
