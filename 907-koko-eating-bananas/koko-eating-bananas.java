class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = 0;
        for(int i : piles){
            if(max < i) max = i;
        }
        int left = 1;
        int right = max;


        int mid = 0;

        while(left < right){
            mid = left + (right - left)/2;

            int used_hour = check(piles, h, mid);

            if( used_hour <= 0){
                right = mid;

            }

            else{
                left = mid+1;
                
            }
                
        }

        return left;
        
    }

    public int check(int[]piles, int h, int candi_rate){
        
        int hours = 0;

        for(int i : piles){
            hours += i/candi_rate + ( i%candi_rate != 0 ? 1 : 0);
        }

        return hours - h;

    }
}