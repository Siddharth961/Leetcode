class Solution {
    int modulo = 1000000007;
    public int countGoodNumbers(long n) {
        
        int ans = 0;


        long even = (n/2 + n%2) ;

        long odd = (n - even) ;

        // for(int i=0; i<n; i++){

        // }

        long a = get_pow(5, even);
        long b = get_pow(4, odd);

        return (int)( (a * b) % modulo);
    }

    public long get_pow(int num, long power){

        if(power == 0) return 1;

        long val = get_pow(num, power/2 ) ;

        long ans = (val * val) % modulo;

        if(power % 2 == 0) return ans;

        return (ans * num) % modulo;
    }
}