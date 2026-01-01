class Solution {

    List<List<Integer>> ans = new LinkedList();
    public List<List<Integer>> permute(int[] nums) {
        get_ans(0, nums);

        return ans;
    }

    public void get_ans(int idx, int[]nums){

        if(idx == nums.length){
            List<Integer> ll = new LinkedList<>();
            for(int i:nums) ll.add(i);

            ans.add(ll);
            return;
        }

        for(int i=idx; i<nums.length; i++){
            swap(i, idx, nums);
            get_ans(idx+1, nums);
            swap(i, idx, nums);

        }
    }

    public void swap(int a, int b, int[]nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}