class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int sum=0;
        int val = 0;
        

        for(int i=0; i<nums.length; i++){
            
            sum += nums[i];

             val = sum % k;

            if(mp.containsKey(val)){
                if(i-mp.get(val) > 1) return true;
            }
            else mp.put(val, i);
        }

        return false;
    }
}