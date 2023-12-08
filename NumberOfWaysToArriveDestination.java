class Solution {
    
   static class Road {
        int value;
        long dist;
        
        public Road(int value, long dist) {
            this.value = value;
            this.dist = dist;
        }
    }

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        
        List<List<Road>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.size(); i++) {
            int u = roads.get(i).get(0);
            int v = roads.get(i).get(1);
            int w = roads.get(i).get(2);
            
            adj.get(u).add(new Road(v, w));
            adj.get(v).add(new Road(u, w));
        }
        
        PriorityQueue<Road> queue = new PriorityQueue<>((road1, road2) -> (int)(road1.dist - road2.dist));
        int[] ways = new int[n];
        ways[0] = 1;
        long[] dist = new long[n];
        for (int i = 1; i< n; i++) dist[i] = Long.MAX_VALUE;
        int mod = (int)(1e9 + 7);
        
        queue.add(new Road(0, 0));
        
        while (!queue.isEmpty()) {
            Road road = queue.remove();
            
            for (Road adjRoad : adj.get(road.value)) {
                if (road.dist + adjRoad.dist < dist[adjRoad.value]) {
                    queue.add(new Road(adjRoad.value, road.dist + adjRoad.dist));
                    dist[adjRoad.value] = road.dist + adjRoad.dist;
                    ways[adjRoad.value] = ways[road.value];
                } else if (road.dist + adjRoad.dist == dist[adjRoad.value]) {
                    ways[adjRoad.value] = (ways[adjRoad.value] + ways[road.value]) % mod ;
                }
            }
        }
        
        return ways[n - 1] % mod;
        
    }
}
