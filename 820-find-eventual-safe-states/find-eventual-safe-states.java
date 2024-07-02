class Solution {
    List<Integer>al = new ArrayList<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int[]safe = new int[graph.length];
        
        for(int i=0; i<graph.length; i++){
            get_ans(graph, i, safe);
        }

        Collections.sort(al);

        return al;
    }

    public void get_ans(int[][]graph, int src, int[]safe){

        if(safe[src] != 0 ) return;

        safe[src] = 2;

        int ans = 1;
        for(int i : graph[src]){
            get_ans(graph, i, safe);
            ans = safe[i];
            if(ans == 2) break;
        }

        safe[src] = ans;
        if(ans==1) al.add(src);
    }
}