class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int[]prefix = new int[nums.length];
        

        for(int i=0; i<nums.length; i++){
            
            if(i==0) prefix[i] = nums[i];
            else prefix[i] = (prefix[i-1] + nums[i]);

            int val = prefix[i] % k;

            if(mp.containsKey(val) && i-mp.get(val) > 1) return true;
            if(!mp.containsKey(val)) mp.put(val, i);
        }

        return false;
    }
}