class Solution {
    
    static boolean[] generateSieve(int N) {
        boolean[] sieve = new boolean[N+1];
        for (int i=2; i<=N; i++) {
            sieve[i] = true;
        }
        
        for(int i=2; i*i<=N; i++) {
            if (sieve[i]) {
                for (int j=i*i; j<=N; j+=i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }
    
    static List<Integer> filterPrimes(boolean sieve[]) {
        List<Integer> primes = new ArrayList<>();
        for (int i=2; i<sieve.length; i++) {
            if (sieve[i]) primes.add(i);
        }
        return primes;
    }
    
    static String isSumOfTwo(int N){
        // code here
        boolean[] sieve = generateSieve(N);
        List<Integer> primes = filterPrimes(sieve);
        int lb = 0;
        int ub = primes.size() - 1;
        while (lb < ub) {
            int sum = primes.get(lb) + primes.get(ub);
            int selfLbSum = primes.get(lb) + primes.get(lb);
            int selfUbSum = primes.get(ub) + primes.get(ub);
            if (selfLbSum == N || selfUbSum == N || sum == N) {
                return "Yes";
            } else if (sum > N) {
                ub--;
            } else { //sum <N
                lb++;
            }
        }
        return "No";
    }
}
