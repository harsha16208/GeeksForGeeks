class Solution {
    
    class Pair {
        int node;
        int dist;
        
        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    
    Queue<Integer> topoSort(List<List<Pair>> adj, int N) {
        int[] indegree = new int[N];
        
        for (int i = 0; i < adj. size(); i++) {
            for (Pair adjNode : adj.get(i)) {
                indegree[adjNode.node]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        Queue<Integer> topo = new LinkedList<>();
        
        while (!queue.isEmpty()) {
            int node = queue.remove();
            topo.add(node);
            
            for (Pair adjNode : adj.get(node)) {
                indegree[adjNode.node]--;
                if (indegree[adjNode.node] == 0) {
                    queue.add(adjNode.node);
                }
            }
        }
        
        return topo;
        
    }
    

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		List<List<Pair>> adj = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
		    adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
		    adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		}
		
		
		Queue<Integer> topoSort = topoSort(adj, N);
		int[] res = new int[N];
		
		for (int i = 1; i < N; i++) {
		    res[i] = (int)(1e9);
		}
		
		while (!topoSort.isEmpty()) {
		    int node = topoSort.remove();
		    
		    for (Pair adjNode : adj.get(node)) {
		        int dist = res[node] + adjNode.dist;
		        res[adjNode.node] = Math.min(res[adjNode.node], dist);
		    }
		}
		
		for (int i = 0; i < N; i++) {
		    if (res[i] == (int)(1e9)) {
		        res[i] = -1;
		    }
		}
		
		return res;
		
	}
}
