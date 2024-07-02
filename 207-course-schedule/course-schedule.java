class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[]graph = new ArrayList[numCourses];

        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();

        for(int[]arr : prerequisites){

            graph[ arr[1] ].add(arr[0]);
        }


        boolean[]visited = new boolean[numCourses];

        boolean[]reached = new boolean[numCourses];

        for(int i=0; i<reached.length; i++){

           if(reached[i]==false) get_ans(graph, i, visited, reached) ;
        }

        for( boolean val : reached) if(!val) return false;       

        return true;

    }

    public void get_ans(ArrayList<Integer>[]graph, int src,boolean[]visited, boolean[]reached){

        if( visited[src]==true ) return ;

        if(graph[src].size()==0){
            reached[src] = true;
            return ;
        }

        visited[src] = true;

        boolean ans = true;
        
        for(Integer e : graph[src]){
            if( visited[e]==false){
                get_ans(graph, e, visited, reached);
                
            }

            ans = reached[e];
            if(ans==false) break;
        }

        reached[src] = ans;
    }
}