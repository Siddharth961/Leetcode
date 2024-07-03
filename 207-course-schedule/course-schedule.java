class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[]graph = new ArrayList[numCourses];
        int[]inward = new int[numCourses];

        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();


        for(int[]arr : prerequisites){

            graph[ arr[1] ].add(arr[0]);

            inward[ arr[0] ]++;
        }


        boolean[]visited = new boolean[numCourses];

        ArrayList<Integer> topo = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<inward.length; i++) if(inward[i]==0) q.add(i);

        while(q.size()>0){

            int node = q.poll();

            topo.add(node);
            visited[node] = true;

            for(int n : graph[node] ){
                
                if(!visited[n]){
                    inward[n]--;
                    if(inward[n]==0)q.add(n);
                }
            }
        }

        if(topo.size()==numCourses) return true;
        return false; 

    }

}