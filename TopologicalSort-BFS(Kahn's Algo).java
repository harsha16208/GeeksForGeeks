class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] inDegree = new int[V];
        int[] res = new int[V];
        int cursor = 0;
        for (int i = 0; i < V; i++) {
            for (Integer adjNode : adj.get(i)) {
                inDegree[adjNode]++;
            }
        }
        
       Queue<Integer> queue = new LinkedList<>();
       
       for (int i = 0; i < V; i++) {
           if (inDegree[i] == 0) {
               queue.add(i);
           }
       }
       
       while(!queue.isEmpty()) {
           int node = queue.remove();
           res[cursor] = node;
           cursor++;
           for (Integer adjNode : adj.get(node)) {
               inDegree[adjNode]--;
               if (inDegree[adjNode] == 0) {
                   queue.add(adjNode);
               }
           }
       }
       
       return res;
       
    }
}
