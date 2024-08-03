class Solution {
    public int findIntegers(int n) {
        return get_ans( 1, n) + 1;
    }

    public int get_ans( int val, int n){
        if(val > n) return 0;
        if( val == n) return 1;

        int ans = 0; 

        ans += get_ans( val*2, n);
        if(val%2 == 0) ans += get_ans( val*2 + 1, n);

        return ans + 1;
    }
}