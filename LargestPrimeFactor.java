class Solution{
    static long largestPrimeFactor(int N) {
        // code here
        int max = 2;
        while (N%2==0) {
            N=N/2;
        }
        
        for (int i=3; i*i<=N; i+=2) {
            while (N%i == 0) {
                N=N/i;
                max = i;
            }
        }
        
        if (N > 2) {
            max = N;
        }
        
        return max;
    }
}
