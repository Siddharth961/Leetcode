class Solution {
    public class Pair implements Comparable<Pair>{
        double ratio;
        int quality;

        Pair(double d, int q){
            ratio = d;
            quality = q;
        }

        @Override
        public int compareTo(Pair p){
            return Double.compare(this.ratio, p.ratio);
        }

    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        Pair[]arr = new Pair[wage.length];
        
        for(int i=0; i<wage.length; i++){
            arr[i] = new Pair( (double)wage[i]/(double)quality[i], quality[i]);
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>( Collections.reverseOrder() );

        int total = 0;
        double ans=Integer.MAX_VALUE;

        for(Pair p : arr){
            
            total += p.quality;
            pq.add( p.quality );

            if(pq.size() > k){
                total -= pq.poll();
                
            }

            if(pq.size()==k){
                ans = Math.min(ans, total * p.ratio);
            }
        }

        return ans;
    }
}