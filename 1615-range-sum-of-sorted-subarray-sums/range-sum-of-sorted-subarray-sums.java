class Solution {
    public class Pair implements Comparable<Pair>{
        int sum;
        int idx;

        Pair(int s, int i){
            sum = s;
            idx = i;
        }

        @Override
        public int compareTo( Pair p2){
            return this.sum - p2.sum;
        }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {

        int modulo = 1000000007;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0; i<nums.length; i++){
            pq.add(new Pair(nums[i], i));
        }

        

        int count = 0;
        int ans = 0;

        while(pq.size() > 0){
            count++;
            if(count>right) break;
            Pair p = pq.poll();
            if(count>=left) ans = (ans + p.sum)%modulo;

            if(p.idx + 1 < nums.length){
                p.sum += nums[ p.idx+1 ];
                p.idx++;
                pq.add(p);
            }


        }

        return ans;
    }
}