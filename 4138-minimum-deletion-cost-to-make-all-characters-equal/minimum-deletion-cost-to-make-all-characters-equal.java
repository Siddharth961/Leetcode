class Solution {
    public long minCost(String s, int[] cost) {
        
        HashMap<Character, Long> mp = new HashMap<>();

        long sum = 0;
        long max = Integer.MIN_VALUE;

        for(int i=0; i<cost.length; i++){
            char c = s.charAt(i);

            long val = mp.getOrDefault(c, 0L);

            val += cost[i];

            sum += cost[i];
            max = Math.max(max, val);
            mp.put(c, val);

        }

        return sum - max;

        
    }
}