class Solution {
    public int maximumProduct(int[] nums) {

        // need to check combos
        // 3 max els
        // 2 most smallest which are negative + max el
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int min1 = 1001;
        int min2 = 1001;
        int max = -1001;

        for(int val : nums){

            if(pq.size() < 3) pq.add(val);
            else{
                if(pq.peek() < val){
                    pq.remove();
                    pq.add(val);
                }
            }

            if(min1 > val){
                min2 = min1;
                min1 = val;
            }
            else if(min2 > val) min2 = val;

            max = Math.max(max, val);
        }

        int ans = 1;
        for(int val : pq) ans *= val;

        ans = Math.max( ans, min1 * min2 * max);


        return ans;
    }
}