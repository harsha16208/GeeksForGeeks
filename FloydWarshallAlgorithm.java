class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int n = matrix.length;
        for (int i = 0 ; i < n; i++) {
            for (int j =0; j < n ; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int)1e9;
                }
            }
        }
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Math.min(matrix[j][i] + matrix[i][k],
                        matrix[j][k]
                    );
                }
            }
        }
        
        for (int i = 0 ; i < n; i++) {
            for (int j =0; j < n ; j++) {
                if (matrix[i][j] == (int)1e9) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
