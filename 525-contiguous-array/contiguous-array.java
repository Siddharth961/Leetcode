class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int max = 0;
        int prefix = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) prefix -= 1;
            else prefix += 1;

            if(mp.containsKey(prefix)){
                int len = i - mp.get(prefix) ;
                
                if(max<len) max = len;
            }
            else mp.put(prefix, i);

            if(prefix==0) max = Math.max(max, i+1);
        }
        
        return max;
    }
}