class Solution {
    public int findMaxLength(int[] nums) {
        int[]sum = new int[nums.length];
        HashMap<Integer, Integer> mp = new HashMap<>();

        int prefix = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) prefix -= 1;
            else prefix += 1;

            sum[i] = prefix;
            mp.put(prefix, i);
        }
        // System.out.println(mp);
        int max = 0;
        for(int i = 0; i<sum.length; i++){
            int len = mp.get(sum[i]) - i;
            if(sum[i]==0) len = i+1;
            if(max<len) max = len;
        }
        return max;
    }
}