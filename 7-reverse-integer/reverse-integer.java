class Solution {
    public int reverse(int x) {
        long val = 0;

        boolean negative = x < 0;

        if( negative ) x *= -1;

        while(x > 0){
            val = val*10 + x%10;
            x /= 10;
        }

        if( negative ) val *= -1;

        // System.out.println(val);

        if( val < Integer.MIN_VALUE || val > Integer.MAX_VALUE) return 0;

        return (int)val;
    }
}