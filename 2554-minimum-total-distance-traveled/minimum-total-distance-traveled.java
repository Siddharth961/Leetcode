class Solution {

    static final long INF = (long)1e15;

    long[][]dp ;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);


        List<Integer> fact_list = new ArrayList<>();

        for(int[]f : factory){

            while(f[1] > 0){
                 fact_list.add(f[0]);
                 f[1]--;
            }
        }

        dp = new long[robot.size()][fact_list.size()];

        for(var a : dp)Arrays.fill(a, -1);

        // System.out.println(fact_list);

        return solve(0, 0, robot, fact_list);
        // return 1;


    }

    public long solve(int i, int j, List<Integer> robot, List<Integer> fact){

        if(i == robot.size() && j <= fact.size() ) {

            // all robos placed
            return 0;

        }

        if(  j == fact.size() ){

            // no more factories 

            return INF;
        }

        if(dp[i][j] != -1) return dp[i][j];

        // take - place i th robot in j th factory(expanded)

        long a = solve(i+1, j+1, robot, fact);

        if(a != INF) a += Math.abs( (long)robot.get(i) - fact.get(j)) ;

        // skip - skipping current factory

        long b = solve(i , j+1, robot, fact);

        long ans = Math.min(a, b);

        dp[i][j] = ans;

        return ans;

    }
}