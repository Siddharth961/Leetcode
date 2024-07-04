class Solution {
    public int findCircleNum(int[][] isConnected) {

        ArrayList<Integer>[]graph = new ArrayList[isConnected.length];
        
        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){

                if(isConnected[i][j]==1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length];
        int ans = 0;
        for(int i=0; i<visited.length; i++){
            if(visited[i]==false){
                get_ans(graph, i, visited);
                ans++;
            }
        }
        
        return ans;
        
    }

    public static void get_ans(ArrayList<Integer>[]graph, int src, boolean[]visited){
        
        if(visited[src]==true) return;
        
        visited[src] = true;
        
        for(int n : graph[src]){
            get_ans(graph, n, visited);
        }
    }
}