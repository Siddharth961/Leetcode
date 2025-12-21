class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);

        // we will do binary search on distance range we can have i.e, 1 to max element in position
        // with small distance we will more likely be able to put all balls but that is not the answer
        // our range will give answers as T T T T T T T...T F F F F F..
        // so we find the last true that will occur

        int l = 1;
        int h = position[position.length - 1];
        int mid = 0;
        int ans =  0;

        while(l <= h){

            mid = ( h - l)/2 + l;

            if( check(mid, m, position) ){ // got a valid put distance
                ans = Math.max(ans, mid);
                l = mid+1;
            }

            else h = mid-1;

        }

        return ans;
    }

    public boolean check(int dist, int m, int[]position){

        // System.out.println(dist);

        int i = 0;
        int last_placed = -1;

        while( i<position.length && m > 0){

            if(last_placed == -1 || (position[i]-last_placed) >= dist ){ // Have not put any ball now Or found a valid put positon in respect last put

                m--;
                last_placed = position[i];
            }

            // if(dist == 500000000) System.out.println()

            i++;

        }

        return m == 0 ;
    }
}