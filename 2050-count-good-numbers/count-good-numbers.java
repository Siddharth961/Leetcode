class Solution {
    long Mod = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n - even;

        long ans = pow(5,even) * pow(4,odd) % Mod;
         

         return (int)ans;
    }

    public long pow(long x, long n){
        if(n==0) return 1;

        long temp = pow(x,n/2);

        if(n%2==0) return (temp*temp)%Mod;
        return (x*temp*temp)%Mod;
    }
}