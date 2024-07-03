class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[]graph = new ArrayList[numCourses];

        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();

        for(int[]arr : prerequisites){

            graph[ arr[1] ].add(arr[0]);
        }


        boolean[]visited = new boolean[numCourses];

        boolean[]finished = new boolean[numCourses];

        for(int i=0; i<finished.length; i++){

           if(finished[i]==false) get_ans(graph, i, visited, finished) ;
        }

        for( boolean val : finished) if(!val) return false;       

        return true;

    }

    public void get_ans(ArrayList<Integer>[]graph, int src,boolean[]visited, boolean[]finished){

        if( visited[src]==true ) return ;

        

        visited[src] = true;

        boolean ans = true;
        
        for(Integer e : graph[src]){
            
            get_ans(graph, e, visited, finished);              
            

            ans = finished[e];
            if(ans==false) break;
        }

        finished[src] = ans;
    }
}