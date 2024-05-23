class Solution {
    HashMap<Integer, Integer> mp = new HashMap<>();
    int ans = 0;

    public int beautifulSubsets(int[] nums, int k) {
        get_ans(0, true, nums, k);
        return ans;
    }

    public void get_ans(int idx, boolean empty, int[]nums, int k){

        if(idx==nums.length){
            if(empty!=true){
                ans++;
            }

            return ;
        }

        
        if( !mp.containsKey(nums[idx]-k) && !mp.containsKey(nums[idx]+k)){

            mp.put(nums[idx], mp.getOrDefault(nums[idx],0) + 1 );
            get_ans(idx+1, false, nums, k);
            
            if(mp.get(nums[idx]) > 1){
                mp.put(nums[idx], mp.get(nums[idx])-1 );
            }
            else mp.remove(nums[idx]);
        }

        get_ans(idx+1, empty, nums, k);
    }
}