class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[]graph = new LinkedList[numCourses];
        int[]inedge = new int[numCourses];

        for(int i=0; i<numCourses; i++) graph[i] = new LinkedList<>();

        for(int[]arr : prerequisites){

            graph[ arr[1] ].add( arr[0] );

            inedge[ arr[0] ]++;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[]visited = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) if(inedge[i] == 0) q.add(i);

        int[]ans = new int[numCourses];
        int idx = 0;

        while(q.size() > 0){
            int node = q.remove();

            ans[idx] = node;
            idx++;

            visited[node] = true;

            for(int neig : graph[node]){

                if( !visited[neig] ){
                    inedge[neig]--;
                    if(inedge[neig] == 0) q.add(neig);
                }
            }
        }

        // System.out.println(topo);


        return idx == ans.length ? ans : new int[]{};
    }
}