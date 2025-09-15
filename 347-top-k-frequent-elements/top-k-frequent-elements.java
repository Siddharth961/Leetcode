class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i: nums) mp.put(i, mp.getOrDefault(i, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0] - b[0]);

        for( var e : mp.keySet() ){
            int val = mp.get(e);

            if(pq.size() < k){
                pq.add( new int[]{val, e} );
            }
            else{
                int[] arr = pq.peek();

                if( arr[0] < val){

                    pq.remove();
                    pq.add( new int[]{val, e} );
    
                }
            }
        }

        int[]ans = new int[k];

        int idx = 0;

        for( int[]a : pq){
            ans[idx] = a[1];
            idx++;
        }

        return ans;
    }
}