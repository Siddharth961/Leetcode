class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        
        List<Integer>[]rev_graph = new LinkedList[n];
        int[]outgoing = new int[n];

        for(int i=0; i<n; i++) rev_graph[i] = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j : graph[i]){

                rev_graph[j].add(i);
            }

            outgoing[i] = graph[i].length;
        }

        // for(var ll : rev_graph) System.out.println(ll);

        Queue<Integer> q = new LinkedList<>(); // will only contain terminal nodes

        for(int i=0; i<n; i++){
            if(outgoing[i] == 0) q.add(i);
        }



        while(q.size() > 0){
            int node = q.remove();

            // now minus the connection from other nodes to this node
            for(int neig : rev_graph[node]){
                outgoing[neig]--;

                if(outgoing[neig] == 0) q.add(neig);
                //since elements are added only after verifying they are terminal nodes ( no outgoing ), there wont be repeated elements in queue
            }
        }

        List<Integer>ans = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(outgoing[i] == 0) ans.add(i);
        }

        return ans;
    }
}