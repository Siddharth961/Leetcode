class Solution {
    public int maxFrequency(int[] nums, int k) {
        // HashMap<Integer, Integer> mp = new HashMap<>();

        // int total_k = 0;

        // int ans = 0;

        // for(int i : nums) if(i == k) total_k++;

        

        // for(int i=1; i<=50; i++){
        //     ans = Math.max( ans, check(k, i, total_k, nums) );
        // }

        // return Math.max(ans, total_k);

        int[]max_till_now = new int[51]; // max if we think of each element individually

        int max = 0; // global max

        int k_till_now = 0;

        for(int i : nums){
            if(i == k){
                k_till_now++;

                max_till_now[i] = max + 1; // i == k can contribute to any previous sub array

            }
            else{
                max_till_now[i] = Math.max(k_till_now,  max_till_now[i] ) + 1; // we checking that if after previous max calculated for i.. is freq of k now bigger than it now ( that is reverting any changes made ) or should we start or continue changing

            }

            max = Math.max(max, max_till_now[i] ); // updating global max
        }

        return max;
    }

    public int check(int k, int tar, int total_k, int[]nums){

        int ans = 0;
        int lost_k = 0;
        int max_freq = 0;

        for(int i : nums){

            if(i == k){
                lost_k++;
            }
            if( i == tar ) max_freq++;

            int val = max_freq + total_k - lost_k;
            // System.out.println(val +" "+ max_freq + " " + total_k + " " + lost_k);

            if( max_freq - lost_k <= 0){
                lost_k = 0;
                max_freq = 0;
            }


            ans = Math.max(ans, val);

        }

        return ans;
    }
}

// brute force - 
// take all subarrays and covert every subarray such that max freq element changes to k, then add rest of already k elements to ans

// so o(n2) for every sub array.. max freq element can be calculated along the way and also number of k in this subarray along the way

// then ans - total k - subarray k + max freq of element