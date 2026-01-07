class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        
        long ans = 0;

        long invalid_zero = 0;
        long invalid_one = 0;

        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) != t.charAt(i)){
                if(s.charAt(i) == '0') invalid_zero++;
                else invalid_one++;
            }

        }

        if(2 * flipCost >= swapCost){

            long swaps = Math.min(invalid_zero, invalid_one);

            ans += swaps*swapCost;

            invalid_zero -= swaps;
            invalid_one -= swaps;
        }

        if( 2 * flipCost >= swapCost + crossCost){

            long swaps = invalid_zero/2 + invalid_one/2; // ACTUALLY only one of the REMAINING invalid types will be greater than 0

            ans += swaps * (swapCost + crossCost);

            invalid_zero %= 2;
            invalid_one %= 2;
            

        }

        // remaining all we will do by flipping
        
        ans += flipCost * ( invalid_zero + invalid_one); 

        return ans;


    }
}