class Solution {
    
    class Pair {
        int val;
        int steps;
        
        public Pair(int val, int steps) {
            this.val = val;
            this.steps = steps;
        }
    }
    
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int n = 100000;
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = (int)1e9;
        }
        steps[start] = 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));
        
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            
            
            if (pair.val == end) {
                return pair.steps;
            }
            
            for (int adj : arr) {
                int res = (pair.val * adj) % n;
                if ((pair.steps + 1) < steps[res]) {
                    steps[res] = pair.steps + 1;
                    queue.add(new Pair(res, pair.steps + 1));
                }
            }
        }
        
        return -1;
        
    }
}
