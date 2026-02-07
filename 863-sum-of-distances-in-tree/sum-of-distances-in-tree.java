class Solution {
    int total_nodes;
    int[]subtree_size;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        List<Integer>[] tree = new LinkedList[n];
        subtree_size = new int[n];
        total_nodes = n;

        Arrays.fill(subtree_size, 1);

        for(int i=0; i<n; i++) tree[i] = new LinkedList<>();

        for(var e : edges){

            tree[ e[0] ].add(e[1]);
            tree[ e[1] ].add(e[0]);

        }

        int[]ans = new int[n];

        ans[0] = get_par_ans(0, -1, 0, tree);

        fill_ans(0, -1, ans, tree);

        return ans;
    }

    public int get_par_ans(int root, int parent, int dist, List<Integer>[] tree){

        int childs = 0;
        int total_dist = 0;

        for(int neig : tree[root]){
            if(neig == parent) continue;

            total_dist += get_par_ans(neig, root, dist+1, tree);
            subtree_size[root] += subtree_size[neig];
        }


        return total_dist + dist;

    }

    public void fill_ans(int root, int parent, int[]ans, List<Integer>[]tree){

        if(parent != -1){
            ans[root] = ans[parent] + (total_nodes - subtree_size[root] ) - (subtree_size[root] ) ;
        }

        for(int neig : tree[root]){
            if(neig == parent) continue;

            fill_ans(neig, root, ans, tree);
        }

    }
}