class Solution {
    public int removeStones(int[][] stones) {
        boolean[]visited = new boolean[stones.length];
        int rem = 0;
        for(int i=0; i<stones.length; i++){
            if( !visited[i] ){
                rem++;
                get_ans(i, stones, visited);
            }
        }

        return stones.length-rem;
    }

    public void get_ans(int idx, int[][]stones, boolean[]visited){
        if(visited[idx]) return;

        visited[idx] = true;
        int x = stones[idx][0];
        int y = stones[idx][1];
        for(int i=0; i<stones.length; i++){
            if( !visited[i]){
                if( stones[i][0] == x || stones[i][1] == y){
                    get_ans(i, stones, visited);
                }
            }
        }
    }


}