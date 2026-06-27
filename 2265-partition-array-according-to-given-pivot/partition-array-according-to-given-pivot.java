class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
         
        int lo_count = 0;
        int eq_count = 0;
        int hi_count = 0;

        for(int i : nums){
            if( i < pivot) lo_count++;
            else if( i == pivot) eq_count++;
            else hi_count++;
        }

        int i=0;
        int j=lo_count;
        int k = j + eq_count;

        int[]ans = new int[nums.length];

        for(int val: nums){
            if( val < pivot){
                ans[i] = val;
                i++;
            }
            else if( val == pivot){
                ans[j] = val;
                j++;
            }
            else{
                ans[k] = val;
                k++;
            }
        }

        return ans;

    }
}