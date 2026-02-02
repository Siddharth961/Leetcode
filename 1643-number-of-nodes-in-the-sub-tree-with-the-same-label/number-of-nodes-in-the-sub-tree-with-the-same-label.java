class Solution {
    int[]ans;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[n];

        LinkedList<Integer>[] tree = new LinkedList[n];

        for(int i=0; i<n; i++) tree[i] = new LinkedList<>();

        for(int[]e : edges){
            tree[ e[0] ].add( e[1] );
            tree[ e[1] ].add( e[0] );
        }

        travel(0, -1, tree, labels);

        return ans;
    }

    public int[] travel(int root, int parent, LinkedList<Integer>[]tree, String labels){

        int[]combined_arr = null;

        int label = labels.charAt(root) - 'a';

        for(int neig : tree[root]){

            if(parent == neig) continue;

            int[]arr = travel(neig, root, tree, labels);            

            if(combined_arr == null ) combined_arr = arr;
            else{
                for(int i=0; i<26; i++){
                    combined_arr[i] += arr[i];
                }
            }

        }

        if(combined_arr == null) combined_arr = new int[26];
        combined_arr[label]++;

        
        ans[root] = combined_arr[label];

        return combined_arr; 
    }
}