class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {

        int m = rolls.length;
        int m_sum = 0;
        for(int i : rolls) m_sum += i;

        int req_sum = ( mean * (n+m)) - m_sum ;

        if( req_sum < n || req_sum > 6*n) return new int[0];

        int[]n_arr = new int[n];

        Arrays.fill(n_arr, req_sum/n );

        int rem = req_sum%n ;
        
        for(int i=0; i<n; i++){

            if( rem >= (6 - n_arr[i]) ){
                rem -= 6 - n_arr[i];
                n_arr[i] = 6;

            }
            else{
                n_arr[i] += rem;
                rem = 0;
            }

            if(rem == 0) break;
        }
        
        if(rem > 0) return new int[0];

        return n_arr; 
    }
}