class Solution {
    
    static void helper(int[][] m, int n, int row, int col, String path, ArrayList<String> res, boolean[][] vis) {
        vis[row][col] = true;
        
        if (row == n - 1 && col == n - 1) {
            res.add(new String(path));
            return;
        }
        
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, -1, 0, 1};
        String[] dir = {"U", "L", "D", "R"};
        
        for (int i = 0; i < delRow.length; i++) {
            int nRow = delRow[i] + row;
            int nCol = delCol[i] + col;
            
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && !vis[nRow][nCol] && m[nRow][nCol] != 0) {
                path += dir[i];
                helper(m, n, nRow, nCol, path, res, vis);
                vis[nRow][nCol] = false;
                path = path.substring(0, path.length() - 1);
            }
        }
    }
    
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        
        ArrayList<String> res = new ArrayList<>();
        if (m[0][0] == 0) return res;
        boolean vis[][] = new boolean[n][n];
        helper(m, n, 0, 0, "", res, vis);
        return res;
    }
}
