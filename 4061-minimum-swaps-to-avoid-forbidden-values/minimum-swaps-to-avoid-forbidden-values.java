class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {

        int n = nums.length;
        
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<n; i++){

            int val = freq.getOrDefault(nums[i], 0);
            val++;
            if(val >= n+1) return - 1;
            freq.put(nums[i], val);

            val = freq.getOrDefault(forbidden[i], 0);
            val++;
            if(val >= n+1) return - 1;
            freq.put(forbidden[i], val);
        }

        HashMap<Integer, Integer> bad_pairs = new HashMap<>();
        int max_bad_grp_size = Integer.MIN_VALUE;
        int total_bad_grps = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == forbidden[i]){
                int val = bad_pairs.getOrDefault(nums[i], 0) + 1;

                max_bad_grp_size = Math.max(max_bad_grp_size, val);
                bad_pairs.put(nums[i], val);

                total_bad_grps++;                                
            }
        }

        return Math.max( max_bad_grp_size, (total_bad_grps + 1)/2 );
    }
}

// 4  6  6  5
// 4  6  5  5

// - first make a map of invalid num , freq - eg 4 is invalid 17 times - 4, 17
// - put these values as a pair in a priotiry queue baesd on freq
// - now for example top two values are - 4, 17 and 6, 12 .. then 12 pairs of and 4 and 7 can swap with each other and become valid.. hence getting as 24 valid numbers

// - after we keep doing that at max only one type of invalid num will remain eg 7, 5 times
// - for these we will use originally valid nums

// - now what if originally valid nums are not enough, what proves that it is DEFINITELY not possible to get valid nums
// - It is because we have moved optimally , at each step we took largest pairs of invalid nums and reduced them.. such that at last if anything remains it is smallest

// - but there is a catch for eg if at last 7 is remaining and in all already valid nums forbidden value is also 7 then even if we have got smallest value it is not correct

// - what we can do is create a map of originally valid 