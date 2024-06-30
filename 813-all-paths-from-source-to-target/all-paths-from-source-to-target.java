class Solution {
    List<List<Integer>> al = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[]visited = new boolean[graph.length];
        get_ans(graph, 0, graph.length-1, visited, new LinkedList<>());
        return al;
    }

    public void get_ans(int[][]graph, int src, int dst, boolean[]visited, List<Integer>asf){

        if(src==dst){
            asf.add(dst);
            al.add( new LinkedList<>(asf) );
            asf.remove(asf.size()-1);
            return ;
        
        }

        if( visited[src] ) return;
        visited[src] = true;

        for(int i : graph[src] ){
            asf.add(src);
            get_ans(graph, i, dst, visited, asf);
            asf.remove(asf.size()-1);
        }

        visited[src] = false;
    }
}