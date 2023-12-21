class Solution{
    
    void subSets(ArrayList<Integer> arr, int index, int N, int sum, ArrayList<Integer> res) {
        if (index == N) {
            res.add(sum);
            return;
        }
        
        subSets(arr, index + 1, N, sum + arr.get(index), res);
        subSets(arr, index + 1, N, sum, res);
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        subSets(arr, 0, N, 0, res);
        return res;
    }
}
