class Solution{
    
    /**
     * This method retuns a sieve which holds the least prime factor for every number
     */
    static int[] generateSieve(int n) {
        int[] sieve = new int[n+1];
        for (int i=2; i<=n; i++) {
            sieve[i] = i;
        }
        
        for (int i=2; i*i<=n; i++) {
            if (sieve[i] == i) {
                for (int j=i*i; j<=n; j+=i) {
                    if (sieve[j] == j) {
                        sieve[j] = i;
                    }
                }
            }
        }
        return sieve;
    }
    
    
    static int kthPrime(int n, int k){
        // code here
        int[] sieve = generateSieve(n);
        
        // Prime factorization
        int i=1;
        while (n>1) {
            if (i==k) {
                return sieve[n];
            }
            n = n / sieve[n];
            i++;
        }
        return -1;
        
    }
}

