class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i : nums) pq.add( (long)i);

        int ans = 0;

        while(pq.peek() < k){


            long x = pq.remove();
            long y = pq.remove();

            pq.add(x + x + y);

            ans++;
        }

        return ans;
    }
}