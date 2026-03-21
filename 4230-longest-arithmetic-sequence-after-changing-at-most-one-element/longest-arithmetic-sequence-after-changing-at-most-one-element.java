class Solution {
    public int longestArithmetic(int[] nums) {

        int n = nums.length;

        
        int[]left = new int[n];
        int[]right = new int[n];

        Arrays.fill(left, 2);
        Arrays.fill(right, 2);

        int ans = 2;

        for(int i=2; i<n; i++){

            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]){
                left[i] = left[i-1]+1;

                ans = Math.max(ans, left[i]);
            }
        }

        for(int i=n-3; i>=0; i--){

            if(nums[i+1] - nums[i+2] == nums[i] - nums[i+1]){
                right[i] = right[i+1] + 1;
                ans = Math.max(ans, right[i]);
            }
        }

        for(int i=0; i<n; i++){

            if(i > 0){
                ans = Math.max(ans, left[i-1] + 1);
            }
            if(i < n-1){
                ans = Math.max(ans, right[i+1] + 1);
            }

            if(i > 0 && i < n-1){

                int d = nums[i+1] - nums[i-1];

                if(d % 2 == 0){
                    int needed_diff = d/2;

                    int l_arr_size = 1;
                    int r_arr_size = 1;

                    if(i-2 >= 0 && nums[i-1] - nums[i-2] == needed_diff){
                        l_arr_size = left[i-1];
                    }

                    if(i+2 < n && nums[i+2] - nums[i+1] == needed_diff){
                        r_arr_size = right[i+1];
                    }

                    ans = Math.max(l_arr_size + r_arr_size + 1, ans);
                }

            }
        }

        return ans;
    }

    
}