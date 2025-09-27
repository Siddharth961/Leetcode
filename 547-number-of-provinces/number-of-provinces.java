class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        
        boolean[]visited = new boolean[n];

        int ans = 0;

        for(int i=0; i<n; i++){
            if( !visited[i] ){
                ans++;
                bfs(i, visited, isConnected);
            }

            System.out.println(ans);
        }

        return ans;
    }

    public void bfs(int n, boolean[]visited, int[][]graph){

        Queue<Integer>q = new LinkedList<>();

        q.add(n);

        while(q.size() > 0){
            int node = q.remove();

            

            visited[node] = true;

            for(int i=0; i<graph.length; i++){

                if( graph[node][i] == 1){

                    if( ! visited[i]){
                        q.add(i);
                    }
                }

            }
        }
    }
}