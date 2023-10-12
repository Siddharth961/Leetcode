class NumArray {
    int[]arr;
        int[] num;


    public NumArray(int[] nums) {
        arr = new int[nums.length];
        int prefix=0;
        for(int i=0; i<nums.length; i++){
            prefix += nums[i];
            arr[i] = prefix;
            
        }

        num = nums;

    }
    
    public int sumRange(int left, int right) {
        
        return  arr[right] - arr[left] + num[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */