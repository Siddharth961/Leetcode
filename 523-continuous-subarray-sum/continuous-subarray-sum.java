class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int sum=0;
        

        for(int i=0; i<nums.length; i++){
            
            sum += nums[i];

            int val = sum % k;

            if(mp.containsKey(val) && i-mp.get(val) > 1) return true;
            if(!mp.containsKey(val)) mp.put(val, i);
        }

        return false;
    }
}