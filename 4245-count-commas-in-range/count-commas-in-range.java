class Solution {
    public int countCommas(int n) {
        
        int commas = 0;

        int num = 1000;

        while(num <= n){

            commas  += Math.max(0, n - (num - 1) );

            num *= 1000;

        }

        return commas;
    }
}
// 1000 -> 