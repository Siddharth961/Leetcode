class Solution {
    public long countCommas(long n) {

        long commas = 0;

        long num = 1000;

        while(num <= n){

            commas  += Math.max(0, n - (num - 1) );

            num *= 1000;

        }

        return commas;
    }
}