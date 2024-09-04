class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int[]ans = new int[queries.length];
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>( Collections.reverseOrder() );

        int val = 0;

        for(int[]arr : queries){

            val = Math.abs(arr[0]) + Math.abs(arr[1]);

            if(pq.size() < k) pq.add(val);
            else{
                if(val < pq.peek()){
                    pq.remove();
                    pq.add(val);
                }
            }

            ans[idx] = pq.size() == k ? pq.peek() : -1;
            idx++;
        }

        return ans;
    }
}