class DisjointSet {
    int[] parent;
    int[] size;
    
    public DisjointSet(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
        this.size = new int[size];
        Arrays.fill(this.size, 1);
    }
    
    public int findUltimateParent(int node) {
        if (node == parent[node]) {
            return parent[node];
        }
        
        return parent[node] = findUltimateParent(parent[node]);
    }
    
    public void unionBySize(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);
        
        if (pu == pv) return;
        
        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}

class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    // code here
    
    int n = accounts.size();
    
    Map<String, Integer> map = new HashMap<>();
    DisjointSet ds = new DisjointSet(n);
    
    for (int i = 0; i< n; i++) {
        for (int j = 1; j < accounts.get(i).size(); j++) {
            String email = accounts.get(i).get(j);
            if (!map.containsKey(email)) {
                map.put(email, i);
            } else {
                ds.unionBySize(i, map.get(email));
            }
        }
    }
    
    List<List<String>> mergedList = new ArrayList<>();
    
    for (int i = 0;  i < n; i++) mergedList.add(new ArrayList<>());
    
    for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
        String email = entry.getKey();
        int node = entry.getValue();
        
        int ultimateParent = ds.findUltimateParent(node);
        mergedList.get(ultimateParent).add(email);
    }
    
    List<List<String>> res = new ArrayList<>();
    
    for (int i = 0; i < n; i++) {
        if (mergedList.get(i).size() == 0) continue;
        Collections.sort(mergedList.get(i));
        List<String> emails = new ArrayList<>(mergedList.get(i));
        String user = accounts.get(i).get(0);
        emails.add(0, user);
        res.add(emails);
    }
    
    return res;
  }
}
     
