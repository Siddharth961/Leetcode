class LockingTree  {

    class TreeNode{
        List<TreeNode> children = new LinkedList<>();
        int val;
        TreeNode parent ;
        int owner = -1;
        // boolean upgraded = false;

        TreeNode(int val){
            this.val = val;
        }

    }

    TreeNode[]tree ;

    public LockingTree(int[] parent) {

        tree = new TreeNode[parent.length];

        // for(int i=0; i<parent.length; i++){
        //     tree[i]
        // }
        
        for(int i=0; i<parent.length; i++){

            int p = parent[i];

            if(p!=-1 && tree[p] == null){
                tree[p] = new TreeNode(p);
            }
            if(tree[i] == null){
                tree[i] = new TreeNode(i);
            }

            if(p!=-1){
                 tree[p].children.add( tree[i] );
                tree[i].parent = tree[p];
            }

        }

        // for(int i=0; i<tree.length; i++){
        //     System.out.print(i + " ");
        //     for(TreeNode node : tree[i].children) System.out.print(node.val);
        //     System.out.println();

        // }

    }
    
    public boolean lock(int num, int user) {
        TreeNode node = tree[num];

        if(node.owner == -1){
            node.owner = user;
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {

        TreeNode node = tree[num];
        if(node.owner == user){
            node.owner = -1;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        
        TreeNode node = tree[num];

        if(node.owner != -1) return false;

        if( uppercheck(node.parent) == false) return false;

        boolean ans = false;

        for(TreeNode child  : node.children) ans = lowercheck(child) || ans;

        if(ans) node.owner = user;

        return ans;

    }

    boolean uppercheck(TreeNode parentNode){

        if(parentNode == null) return true;

        if( parentNode.owner != -1) return false;

        return uppercheck( parentNode.parent );
    }

    boolean lowercheck(TreeNode node){

        boolean ans = false;

        if(node.owner != -1)ans = true;

        node.owner = -1;

        for(TreeNode child : node.children ){

            ans = lowercheck(child) || ans;

        }

        return ans;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */