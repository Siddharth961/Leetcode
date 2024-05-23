class Solution {
    HashMap<Integer, Integer> mp = new HashMap<>();
    int[]freq = new int[1001];
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

        
        if( !(nums[idx]-k>=0 && freq[nums[idx]-k]!=0) && !(nums[idx]+k<1001 && freq[nums[idx]+k]!=0) ){

            freq[ nums[idx] ]++;
            get_ans(idx+1, false, nums, k);
            
            freq[ nums[idx] ]--;
        }

        get_ans(idx+1, empty, nums, k);
    }
}