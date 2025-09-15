class Solution {
    public int minEatingSpeed(int[] piles, int hours) {
        int l = 1;
        int h = 0;

        for(int i : piles) h = Math.max(h, i);

        int mid = 0;
        int ans = h;

        while(l <= h){
            mid = (l + h)/2;

            if( check(mid, hours, piles)){
                ans = Math.min(ans, mid);
                h = mid-1;
            }

            else l = mid+1;
        }

        return ans;

    }

    public boolean check(int rate, int h, int[]piles){

        long taken = 0;

        for(int i: piles){

            taken += i/rate;
            if(i % rate != 0) taken++;
        }



        return taken <= h;
    }
}