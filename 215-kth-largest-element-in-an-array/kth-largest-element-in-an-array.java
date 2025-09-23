class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : nums){

            if(pq.size() < k) pq.add(i);
            else{
                if( i > pq.peek() ){
                    pq.remove();
                    pq.add(i);
                }
            }
        }

        return pq.peek();
    }
}