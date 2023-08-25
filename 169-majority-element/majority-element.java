class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int ans = a;
        int max = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            count++;

            if(i+1==nums.length || a != nums[i+1]){
                if(max<count){
                    max=count;
                    ans = a;
                }
                if(i+1<nums.length) a = nums[i+1];
                count=0;
            }

        }

        return ans;

    }
}