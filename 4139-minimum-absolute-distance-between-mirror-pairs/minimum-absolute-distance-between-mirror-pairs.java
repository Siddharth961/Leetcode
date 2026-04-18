class Solution {
    public int minMirrorPairDistance(int[] nums) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = nums.length + 1;

        for(int i=0; i<nums.length; i++){


            if(mp.containsKey(nums[i])){
                ans = Math.min(ans, i - mp.get(nums[i]));
            }
            int r = rev(nums[i]);

            mp.put(r, i);
        }

        return ans == nums.length+1 ? -1 : ans;
    }

    public int rev(int n){

        int val = 0;

        while(n > 0){
            val = val*10 + n%10;

            n = n/10;
            
        }

        return val;
    }
}