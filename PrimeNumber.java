class Solution{
    static int isPrime(int N){
        if (N==0 || N ==1) return 0;
        // code here
        int factors=1;
        for (int i=2; i*i<=N; i++) {
            if (N%i ==0) {
                factors++;
                if (N%i!=i) {
                    factors++;
                }
            }
        }
        return factors > 2 ? 0 : 1; 
    }
}
