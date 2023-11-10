
class Solution
{
    
    ArrayList<Integer> removeDuplicate(int arr[], int n)
    {
        // code here 
        Set<Integer> filter = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for (Integer i : arr) {
            if (filter.add(i)) res.add(i);
        }
        return res;
    }
}
