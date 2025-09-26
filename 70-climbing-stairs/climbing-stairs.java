class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;

        for(int i = 0; i<=n-2; i++){
            int temp = b;
            b = a+b;
            a = temp;

        }

        return b;
    }
}

//0   1   2   3   4  5   6  7
//21  13  8   5   3  2   1  1

// basically fibonnaci