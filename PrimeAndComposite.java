class Solution
{
    
    boolean[] generateSieve(int N) {
        boolean sieve[] = new boolean[N+1];
        
        for (int i=2; i<=N; i++) sieve[i] = true;
        
        for (int i=2; i*i<=N; i++) {
            if(sieve[i]) {
                for (int j=i*i; j<=N; j+=i) sieve[j] = false;
            }
        }
        return sieve;
    }
    
    public int Count(int L, int R)
    {
        // code here
        boolean[] sieve = generateSieve(R);
        
        int comp = 0, prime = 0;
        
        for (int i=L; i<=R; i++) {
            if (i == 0 || i == 1) continue;
            if (sieve[i]) prime++;
            else comp++;
        }
        
        return comp - prime;
    }
}
