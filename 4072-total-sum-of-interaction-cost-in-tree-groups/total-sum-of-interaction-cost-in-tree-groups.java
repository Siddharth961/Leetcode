class Solution {

    int[]total_nodes_per_grp = new int[21];
    long[][]subtree_count;
    public long interactionCosts(int n, int[][] edges, int[] group) {
        
        List<Integer>[] tree = new LinkedList[n];
        subtree_count = new long[n][];

        for(int i=0; i<n; i++) tree[i] = new LinkedList<>();

        for(var e : edges){
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        long[][]dp = new long[n][21];

        fill_par(0, -1, dp[0], 0, tree, group);

        // for(int i=0; i<21; i++){
        //     System.out.println(i + " " + dp[0][i]);
        // }

        populate_dp(0, -1, tree, dp, group);

        double sum = 0;

        for(int i=0; i<n; i++){

            sum += dp[i][ group[i] ]/2.0;
        }

        return (long)sum;
    }

    // this function will give an array which will hold total distance of all nodes per group
    // and will also fill subtree array with data abount NUMBER of nodes per group in subtree
    public long[] fill_par(int root, int parent, long[]par_arr, int dist, List<Integer>[] tree, int[] group){

        // stores size of all groups in this subtree
        long[]grp_count = new long[21];
        int curr_grp = group[root];

        // in par-count adding dist to root's group
        par_arr[curr_grp] += dist;

        for(int child : tree[root]){
            if(child == parent) continue;

            long[]child_arr = fill_par(child, root, par_arr, dist+1, tree, group);

            for(int i=0; i<21; i++){
                grp_count[i] += child_arr[i];
            }
        }

        grp_count[curr_grp]++;
        total_nodes_per_grp[curr_grp]++;

        subtree_count[root] = grp_count;
        return grp_count;

    }

    public void populate_dp(int root, int parent, List<Integer>[]tree, long[][]dp, int[]group){

        if(parent != -1){

            for(int grp = 1; grp<21; grp++){
                
                long rem_nodes = total_nodes_per_grp[ grp ] - subtree_count[root][grp];

                dp[root][grp] = dp[parent][grp] - subtree_count[root][grp] + rem_nodes;
            }
        }

        for(int child : tree[root]){
            if(child == parent) continue;

            populate_dp(child, root, tree, dp, group);
        }
    }

}

// we do rerooting dp but at each node we maintain seperate track of each group















