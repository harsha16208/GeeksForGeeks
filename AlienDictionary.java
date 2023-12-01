class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        
        
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr)  - 'a');
                    break;
                }
            }
        }
        
        int[] indegree = new int[K];
        for (int i = 0; i < K; i++) {
            for (int adjNode : adj.get(i)) {
                indegree[adjNode]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        String res = "";
        
        while (!queue.isEmpty()) {
            int node = queue.remove();
            res += (char)(node +'a');
            
            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }
        
        return res;
        
    }
}
