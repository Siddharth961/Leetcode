class Solution {
    public int mirrorDistance(int n) {
        
        int num = n;
        int rev_num = 0;

        while(n > 0){
            rev_num = rev_num * 10 + n%10;
            n/=10;
        }

        return Math.abs(num - rev_num);

    }
}