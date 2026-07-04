class Solution {

    int modulo = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {    
    
        int n = edges.length+2; // edges.length is n-1, and nodes are 1 indexed        

        // making tree
        LinkedList<Integer>[] tree = new LinkedList[n];

        for(int i = 1; i < tree.length; i++){
            tree[i] = new LinkedList<>();
        }
        for(int[]e : edges){

            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        // find depths of all elements and their direct parents
        int[]depth = new int[n];
        int[]parent = new int[n];

        findDepth(1, -1, 0, depth, parent, tree);

        // LCA by BINARY LIFTING

        LCA_BL finder = new LCA_BL(parent);

        int[]ans = new int[queries.length];
        int idx=0;
        for(int[]q : queries){

            int LCA = finder.findLCA(q[0], q[1], depth);

            int max_edges = depth[q[0]] + depth[q[1]] - 2*depth[LCA];

            // System.out.println(LCA + " " + max_edges);

            ans[idx] = (int) power2(max_edges-1);
            idx++;
        }


        

        return  ans;
        
    }

    public void findDepth(int curr, int dir_parent, int dsf, int[]depth, int[]parent, LinkedList<Integer>[] tree){

        depth[curr] = dsf;
        parent[curr] = dir_parent;

        for(int child : tree[curr]){
            if(child == dir_parent) continue;
            findDepth(child, curr, dsf+1, depth, parent, tree);
        }

    }

    public long power2(long pow){

        if(pow < 0) return 0;

        if(pow == 0) return 1;

        long val = power2( pow / 2);

        long ans = (1L * val * val) % modulo;

        if(pow % 2 == 1) ans = (ans * 2) % modulo;

        return ans;
    }

    public class LCA_BL{

        int[][]ancestor;
        int n;

        public LCA_BL(int[]parent){

            this.n = parent.length;
            int cols = (int)( Math.floor( Math.log(n) / Math.log(2) )) + 1;

            ancestor = new int[n][cols];
            for(int[]arr : ancestor) Arrays.fill(arr , -1);

            for(int i=0; i<n; i++){
                ancestor[i][0] = parent[i];
            }

            for(int j=1; j<cols; j++){
                for(int i=1; i<n; i++){

                    int mid_par = ancestor[i][j-1];
                    
                    if(mid_par != -1){
                        ancestor[i][j] = ancestor[mid_par][j-1];
                    }
                }
            }

        }

        public int findLCA(int u, int v, int[]depth){

            if(depth[u] > depth[v]){

                u = jumpK(u, depth[u] - depth[v]);

            }
            else{
                v = jumpK(v, depth[v] - depth[u]);
            }

            if(u == v) return u;

            // now u and v are on same level

            int col = ancestor[0].length;

            for(int j=col-1; j>=0; j--){

                if(ancestor[u][j] != ancestor[v][j]){
                    // we make jump 
                    
                    u = ancestor[u][j];
                    v = ancestor[v][j];
                }
            }

            // both and u and v are just below LCA now

            return ancestor[u][0];

        }

        public int jumpK(int node, int k){

            // returns kth ancerstor of node..so that u and v will be on same level

            int pow = 0;
            int curr = node;

            while(k > 0 && pow < ancestor[0].length){

                if( (k & (1 << pow)) > 0){
                    // bit is set, need to make this jump

                    curr = ancestor[curr][pow];
                }

                
                pow++;
            }

            return curr;

        }
    }
}