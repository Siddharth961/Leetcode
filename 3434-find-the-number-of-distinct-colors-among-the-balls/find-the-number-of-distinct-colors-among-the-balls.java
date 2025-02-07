class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();

        HashMap<Integer, Integer> balls = new HashMap<>();
        int[]ans = new int[queries.length];

        int idx = 0;

        for(int[]q : queries){

            if(balls.get(q[0]) != null){

                int color = balls.get(q[0]);
                mp.put( color, mp.get(color) - 1);

                if(mp.get(color) == 0) mp.remove(color);

            }

            mp.put( q[1], mp.getOrDefault( q[1], 0) + 1);
            balls.put(q[0], q[1]);

            ans[idx] = mp.size();
            idx++;

        }

        return ans;
    }
}