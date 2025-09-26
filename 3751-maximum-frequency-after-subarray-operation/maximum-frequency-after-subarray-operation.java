class Solution {
    public int maxFrequency(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        // int lost_k = 0;
        int total_k = 0;
        // int max_freq = 0;

        int ans = 0;

        for(int i : nums) if(i == k) total_k++;

        // for(int i : nums){

        //     if(i == k){
        //         lost_k++;
        //     }
        //     else{
        //         mp.put(i, mp.getOrDefault(i, 0) + 1);

        //         max_freq = Math.max(max_freq, mp.get(i) );
        //     }

        //     int val = max_freq + total_k - lost_k;
        //     System.out.println(val +" "+ max_freq + " " + total_k + " " + lost_k);

        //     if( max_freq - lost_k <= 0){
        //         lost_k = 0;
        //         mp.clear();
        //     }


        //     ans = Math.max(ans, val);

        // }

        for(int i=1; i<=50; i++){
            ans = Math.max( ans, check(k, i, total_k, nums) );
        }

        return Math.max(ans, total_k);
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