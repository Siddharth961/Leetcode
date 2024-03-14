/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class pair{
        TreeNode node;
        int row;
        pair(TreeNode root, int r){
            node = root;
            row = r;
        }
    }

    class sort_list implements Comparator<pair>{

        public int compare(pair a, pair b){
            if(a.row<b.row) return -1;
            else if(a.row>b.row) return 1;
            else{
                if(a.node.val<b.node.val) return -1;
                else if(a.node.val > b.node.val) return 1;
                else return 0;
            }
        }

    }

    TreeMap<Integer, List<pair>> mp;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        mp = new TreeMap<>();
        get_lists(root, 0, 0);


        for(var e : mp.keySet()){
            
            Collections.sort(mp.get(e), new sort_list());
        }
        

        List<List<Integer>> ans = new LinkedList<>();
        for(var e : mp.keySet()){
            List<Integer> al = new LinkedList<>();
            for(var p : mp.get(e)){
                al.add(p.node.val);
            }
            ans.add(al);
        }

        return ans;
    }


    public void get_lists(TreeNode root, int r, int c){
        if(root == null) return ;

        if(mp.containsKey(c) == false) mp.put(c, new LinkedList<>());

        mp.get(c).add( new pair(root, r) );

        get_lists(root.left, r+1, c-1);
        get_lists(root.right, r+1, c+1);
    }
}