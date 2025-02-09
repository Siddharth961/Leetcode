class Solution {
    public long countBadPairs(int[] nums) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++){
            nums[i] -= i;

            mp.put( nums[i], mp.getOrDefault(nums[i], 0) + 1 );
        }

        long good_pairs = 0;
        int val = 0;


        for( var e : mp.values()){
           
            good_pairs += (long)(e) * (e - 1) / 2;

        }

        long n = nums.length ;
        long total_pairs = ((n - 1) * (n))/2;

        return total_pairs - good_pairs;


    }
}