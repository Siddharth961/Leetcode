class Solution {
    int ans = -1;
    HashMap<Integer, Integer> track = new HashMap<>();

    public int longestCycle(int[] edges) {

        boolean[]vis = new boolean[edges.length];

        for(int i=0; i<vis.length; i++){

            if( !vis[i] ){

                track = new HashMap<>();
                track.put(i, 1);
                travel(i, 1, edges, vis);

            }
        }

        return ans;

        
    }

    public void travel(int node, int dsf, int[]edges, boolean[]vis){
        vis[node] = true;

        int neig = edges[node];

        if( neig != -1 && !vis[neig]){
            track.put( neig, dsf+1);
            travel( neig, dsf+1, edges, vis);
        }

        else if( neig != -1 && track.containsKey(neig) == true){

            ans = Math.max(ans, track.get(node) - track.get(neig) + 1);
        }
    }
}