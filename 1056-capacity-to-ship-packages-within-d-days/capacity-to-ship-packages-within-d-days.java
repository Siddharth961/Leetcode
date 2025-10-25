class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int n = weights.length;

        int window_size = n/days + n % days;

        int max_cap = 0;

        int size = 0;
        int i = 0;

        while(i < n){

            size += weights[i];

            if(i >= window_size ) size -= weights[ i - window_size];

            max_cap = Math.max(max_cap, size);
            i++;
        }

        // System.out.println(max_cap);

        return binary(max_cap, days, weights);
    }

    public int binary( int h, int days, int[]weights){
        int l = 1;
        int mid = 0;

        int ans = 1;

        while( l <= h){
            mid = (l + h)/2;

            if( check(mid, days, weights) ){
                ans = mid;
                
                h = mid - 1;
            }
            else l = mid+1;
        }

        return ans;
    } 

    public boolean check(int cap, int days, int[]weights){



        int curr_size = 0;
        int i = 0;

        while(i < weights.length ){

            if( days == 0) return false;

            curr_size += weights[i];
            if(curr_size > cap){
                curr_size = 0;
                days--;

                continue;
            }

            i++;
        }

        // System.out.println(cap);
        return true;
    }
}