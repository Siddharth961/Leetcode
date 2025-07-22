class Solution {

    class Node{
        int val ;
        int indegree = 0;
        LinkedList<Integer> neig = new LinkedList<>();

        Node(int v){ val = v;}
    }
    public int[] findOrder(int n, int[][] edges) {

        
        
        Node[]graph = new Node[n];

        for(int i=0; i<n; i++) graph[i] = new Node(i);

        for( int[]e : edges){
            graph[ e[1] ].neig.add( e[0] );

            graph[ e[0] ].indegree++;
        }

        Stack<Node> st = new Stack<>();
        int[]ans = new int[n];
        int idx = 0;

        while(true){

            for(Node node : graph){

                if(node.indegree == 0) st.push(node);

            }

            if(st.size() == 0) break;

            while( st.size() > 0){
                Node node = st.pop();

                for(int i : node.neig){
                    graph[i].indegree--;
                }

                node.indegree = -1;

                ans[idx] = node.val;
                idx++;
            }
        }

        for(Node node : graph) if(node.indegree > 0) ans = new int[0];

        return ans;



    }
}