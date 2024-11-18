class NumArray {

    int[]nums;
    int[]tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[4*nums.length];
        make_tree(0, 0, nums.length-1, tree, nums);


    }
    
    public void update(int index, int val) {

        help_update(0, 0, nums.length-1, index, val);

    }
    
    public int sumRange(int left, int right) {
        return help_sum(0, 0, nums.length-1, left, right);
        
    }

    public void make_tree(int curr, int l, int r, int[]tree, int[]nums){
        if(l==r){
            tree[curr] = nums[l];
            return ;
        }

        int mid = (l+r)/2;

        make_tree(2*curr + 1, l, mid, tree, nums);
        make_tree(2*curr + 2, mid+1, r, tree, nums);

        tree[curr] = tree[2*curr+1] + tree[2*curr+2];
    }

    public void help_update(int curr, int l, int r, int tar, int val){
        if(l == r){
            tree[curr] = val;
            return ;
        }

        int mid = (l+r)/2;

        if(tar<=mid) help_update(2*curr + 1, l, mid, tar, val);
        else help_update(2*curr + 2, mid+1, r, tar, val);

        tree[curr] = tree[2*curr+1] + tree[2*curr+2];
    }

    public int help_sum(int curr, int l, int r, int st, int en){
        if( en < l || r < st) return 0;

        if( l>=st && r <= en){
            return tree[curr];
        }

        int mid = (l+r)/2;

        return help_sum(2*curr + 1, l, mid, st, en) + help_sum(2*curr + 2, mid+1, r, st, en);

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */