class Solution{
    
    static boolean[] generateSieve(int N) {
        boolean[] sieve = new boolean[N+1];
        for (int i=2; i<=N; i++) sieve[i] = true;
        
        for (int i=2; i*i<=N; i++) {
            if (sieve[i]) {
                for (int j=i*i; j<=N; j+=i) sieve[j] = false;
            }
        }
        return sieve;
    }
    
    static List<Integer> getPrimesInRange(boolean[] sieve, double R) {
        List<Integer> primes = new ArrayList<>();
        for (int i=2; i<=R; i++) {
            if (sieve[i]) primes.add(i);
        }
        return primes;
    }
    
    
    static long primeProduct(long L, long R){
        // code here
        
        //Step-1: Generate sieve for 10^6 numbers
        boolean[] sieve = generateSieve((int)Math.sqrt(R));
        
        //Step-2: create an array for storing range
        int size = (int) (R-L+1);
        boolean[] range = new boolean[size];
        Arrays.fill(range, true);
        if (L==1) range[0] = false;
        
        /*Step-3: Get Prime factors for given range
        * The prime factors for any number will be under sqrt(n)
        */
        List<Integer> primes = getPrimesInRange(sieve, Math.sqrt(R));
        
        for (Integer prime : primes) {
            long firstMultiple = (int)(L/prime) * prime;
            if (firstMultiple < L) firstMultiple += prime;
            
            for (long j=Math.max(firstMultiple,prime * prime); j<=R; j+=prime) {
                range[(int)(j-L)] = false;
            }
        }
        
        long product = 1;
        for (long i=L; i<=R; i++) {
            // System.out.println(i-L);
            if (range[(int)(i-L)]) {
                product*=i;
                product%=1000000007;
            }
        }
        
        return product;
    }
}
