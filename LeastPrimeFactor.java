class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        // code here
        int[] sieve = new int[n+1];

        for (int i=0; i<=n; i++) {
            sieve[i] = i;
        }
        
        
        for(int i=2; i*i<=n; i++) { //Sqrt times
            if (sieve[i] == i) {
                for (int j=i*i; j<=n; j+=i) {
                     if (sieve[j] == j) {
                        sieve[j]=i;
                    }  
                }
            }
        }
        return sieve;
        
    }
}
