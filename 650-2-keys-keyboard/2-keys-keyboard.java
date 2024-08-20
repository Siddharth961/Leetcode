class Solution {
    public int minSteps(int n) {

        if(n==1) return 0;

        int i = n/2;
        for(; i>=2; i--){
            if(n%i==0) break;
        }

        return minSteps(i) + (n/i) ;
    }

    public int findPrime(int n){

        int ans = 0;

        for(int i=2; i<=n; i++){
            while( n%i == 0){
                ans = i;
                n = n/i;
            }
        }

        if(n>2) ans = n;
        return ans;
    }
}