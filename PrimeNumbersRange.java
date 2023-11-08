
class Solution {
    
    
    static ArrayList<Integer> primeRange(int M, int N) {
        // code here
        boolean sieve[] = new boolean[N+1];
        for (int i=2; i<=N; i++) {
            sieve[i] = true;
        }
        
        for (int i=2; i*i<=N; i++) {
            if (sieve[i]) {
                for (int j=i*i; j<=N; j+=i) {
                    sieve[j] = false;
                }
            }
        }

        for (int i=2; i<sieve.length; i++) {
            if (sieve[i]);
        }
        

        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i=M; i<=N; i++) {
            if (sieve[i]) {
                res.add(i);
            }
        }
        
        return res;
    }

}
