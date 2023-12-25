class solve {
    
    
    boolean isValid(List<List<Integer>> adj, int color, int[] colors, int node) {
        for (int adjNode : adj.get(node)) {
            if (colors[adjNode] == color) return false;
        }
        return true;
    }
    
    boolean solve(int node, List<List<Integer>> adj, int m, int n, int[] colors) {
        if (node == n) {
            return true;
        }    
        
       for (int i = 0; i < m; i++) {
           if (isValid(adj, i, colors, node)) {
               colors[node] = i;
               if (solve(node + 1, adj, m, n, colors)) return true;
                colors[node] = -1;              
           }
       }
       return false;
    }
    
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        List<List<Integer>> adj = new ArrayList<>();
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == true) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        return solve(0, adj, m,n, colors);
    }
}
