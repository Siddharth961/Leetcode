class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][]dist = new int[26][26];

        for(int[]arr : dist) Arrays.fill(arr, Integer.MAX_VALUE);

        for(int i=0; i<original.length; i++){
            if(dist[ original[i]-'a' ][changed[i]-'a' ] > cost[i]){
                dist[ original[i]-'a' ][changed[i]-'a' ] = cost[i];
            }
        }

        for(int via = 0; via<26; via++){

            for(int i=0; i<26; i++){
                for(int j=0; j<26; j++){
                    if(dist[i][via] + dist[via][j] > 0){

                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

        char[]src = source.toCharArray();
        char[]tar = target.toCharArray();

        long ans = 0;

        for(int i=0; i<src.length; i++){

            if(src[i]==tar[i]) continue;

            if(dist[src[i]-'a'][tar[i]-'a'] == Integer.MAX_VALUE) return -1;
            ans += dist[src[i]-'a'][tar[i]-'a'];
        }

        return ans;
    }
}