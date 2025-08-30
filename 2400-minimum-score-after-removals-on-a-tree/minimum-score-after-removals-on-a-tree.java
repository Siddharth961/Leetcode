class Solution {

    public class Node{
        int val;
        LinkedList<Integer> neig = new LinkedList();

        Node(int v){
            val = v;
        }
    }
    public int minimumScore(int[] nums, int[][] edges) {

        int n = nums.length;
        int[]intime = new int[n];
        int[]outtime = new int[n];
        int[]xor = new int[n];

        Node[]graph = new Node[n];

        for(int i=0; i<n; i++){
            graph[i] = new Node( nums[i]);
        }

        for(int[]e : edges){
            graph[ e[0] ].neig.add( e[1] );
            graph[ e[1] ].neig.add( e[0] );
        }

        dfs(0, -1, 0, intime, outtime, xor, graph );

        // for(int i : intime) System.out.print(i + " ");
        // System.out.println();
        // for(int i : outtime) System.out.print(i + " ");
        // System.out.println();
        // for(int i : xor) System.out.print(i + " ");

        int ans = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){

            for(int j=i+1; j<n; j++){

                int xor1 = xor[0];
                int xor2 = xor[i];
                int xor3 = xor[j];

                if( isAncestor(i, j, intime, outtime) ){
                    xor2 = xor2 ^ xor3;

                    xor1 = xor1^ xor[i];
                }
                else if( isAncestor(j, i, intime, outtime) ){

                    xor3 = xor3^xor2;

                    xor1 = xor1^xor[j];
                }

                else{
                    xor1 = xor1 ^ xor2 ^ xor3;
                }

                int largest = Math.max( xor1, Math.max(xor2, xor3 ));
                int smallest = Math.min( xor1, Math.min(xor2, xor3 ));

                ans = Math.min( ans, largest - smallest);
            }
        }


        return ans;



    }



    public void dfs(int time, int parent, int node,int[]intime, int[]outtime, int[]xor, Node[]graph){


        intime[ node ] = time;

        xor[node] = graph[node].val;



        for( int n : graph[node].neig ){
            if(n == parent) continue;

            dfs(time + 1, node, n, intime, outtime, xor, graph);

            time = outtime[n] + 1;

            xor[node] = xor[node]^xor[n];
        }

        outtime[node] = time + 1;


    }

    public boolean isAncestor(int i, int j, int[]intime, int[]outtime){

        return intime[i] < intime[j] && outtime[i] > outtime[j] ;


    }
}