class Solution {
    public boolean validDigit(int n, int x) {
        
        boolean occur = false;
        int last = -1;

        while(n > 0){
            
            int val = n%10;

            if(val == x) occur = true;
            last = val;

            n = n/10;
        }

        return last != x && occur;
    }
}