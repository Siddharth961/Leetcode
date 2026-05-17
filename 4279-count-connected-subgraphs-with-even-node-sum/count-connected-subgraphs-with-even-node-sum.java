class Solution {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        
        int ans = 0;

        for(int mask = 1; mask < (1 << nums.length); mask++){

            boolean check = build_graph(mask, nums, edges);
            if(check) ans++;
        }

        return ans;
    }

    public boolean build_graph(int mask, int[]nums, int[][]edges){

        int root = -1;

        // build graph

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0; i<nums.length; i++){

            if( (mask & ( 1 << i) ) != 0){
                if(root == -1) root = i;
                graph.put(i, new LinkedList<>());
            }

        }

        // connecting points via valid edges

        for(int[]e : edges){

            if(graph.containsKey(e[0]) && graph.containsKey(e[1])){

                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }
        }

        // check if made graph is connected and have sum even

        boolean[]visited = new boolean[nums.length];
        int sum = 0;

        Queue<Integer> q = new LinkedList<>();

        // add any node in queue
        if(root == -1){
            System.out.println(mask);
            return false;
        }
        q.add(root);

        while(q.size() > 0){

            int node = q.remove();

            if(visited[node]) continue;

            visited[node] = true;

            sum += nums[node];

            for(var neighbour : graph.get(node) ){
                if( !visited[neighbour] ){
                    q.add(neighbour);
                }
            }
        }

        for(int node : graph.keySet()){

            if(visited[node] == false) return false;
        }

        return sum%2 == 0;      

    }
}