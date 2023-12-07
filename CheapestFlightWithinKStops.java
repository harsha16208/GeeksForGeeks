class Solution {
    
    class Route {
        int city;
        int cost;
        
        public Route(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
    
    class Data {
        int stops;
        int city;
        int cost;
        
        public Data(int stops, int city, int cost) {
            this.stops = stops;
            this.city = city;
            this.cost = cost;
        }
    }
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        
        ArrayList<ArrayList<Route>> adj = new ArrayList<>();
        
        for (int i = 0;  i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0;  i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int dest = flights[i][2];
            
            adj.get(from).add(new Route(to, dest));
        }
        
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, src, 0));
        int cost[] = new int[n];
        
        for (int i = 0; i< n; i++) {
            cost[i] = (int)1e9;
        }
        cost[src] = 0;
        
        while (!queue.isEmpty()) {
            Data from = queue.remove();
            int stops = from.stops;
            int city = from.city;
            
            if (stops > k) continue;
            
            for (Route route : adj.get(city)) {
                if ((from.cost + route.cost < cost[route.city]) && stops <= k) {
                    cost[route.city] = from.cost + route.cost;
                    queue.add(new Data(stops + 1, route.city, cost[route.city]));
                }
            }
        }
        
        if (cost[dst] == (int)1e9) return -1;
        
        return cost[dst];
    }
}
