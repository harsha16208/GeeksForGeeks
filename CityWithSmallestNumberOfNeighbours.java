class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          int[][] adj = new int[n][n];
          for (int i = 0; i < n; i++) {
              for (int j = 0; j < n; j++) {
                if (i == j) adj[i][j] = 0;
                else adj[i][j] = (int)1e9;
              }
          }
          
          for (int i = 0; i < m; i++) {
              int u = edges[i][0];
              int v = edges[i][1];
              int w = edges[i][2];
              
              adj[u][v] = w;
              adj[v][u] = w;
          }
          
          for (int via = 0; via < n; via++) {
              for (int i = 0; i < n; i++) {
                  for (int j = 0; j < n; j++) {
                      adj[i][j] = Math.min(adj[i][via] + adj[via][j], adj[i][j]);
                  }
              }
          }
          
          int minCities = n;
          int node = -1;
          
          for (int i = 0; i < n; i++) {
              int count = 0;
              for (int j = 0; j < n; j++) {
                  if (adj[i][j] <= distanceThreshold) {
                      count++;
                  }
              }
              
              if (minCities >= count) {
                  minCities = count;
                  node = i;
              }
          }
          
          return node;
          
      }
}
