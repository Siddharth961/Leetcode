class Solution {
    public int countTrapezoids(int[][] points) {
        
        HashMap<Integer, Long> points_per_level = new HashMap<>();

        long modulo = 1000000007;

        for(int[]p : points){
            
            points_per_level.put(p[1], points_per_level.getOrDefault(p[1], 0L) + 1);
        }

        long[]pairs_per_level = new long[points_per_level.size()];

        int idx = 0;

        for(var k : points_per_level.keySet() ){

            long points_count = points_per_level.get(k);

            // if(points_count < 2) continue;

            long pairs = (points_count * (points_count - 1))/2 ;

            pairs_per_level[idx] = pairs % modulo;
            
            idx++;
        }

        long ans = 0;
        long total_pairs = 0;

        for(long curr : pairs_per_level){

            ans = ( ans + curr * total_pairs) % modulo;
            total_pairs = (total_pairs + curr ) % modulo;
        }

        return (int) ans;


    }
}