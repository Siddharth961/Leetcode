class NumArray {

    int[]tree;

    public NumArray(int[] nums) {
        tree = new int[4*nums.length];
        make_tree(0, 0, nums.length-1, tree, nums);
        
    }
    
    public int sumRange(int left, int right) {
        return search(0, 0, tree.length/4 - 1, left, right, tree);
    }

    public int search( int curr, int left, int right, int tar_left, int tar_right,int[]tree ){

        if(tar_right < left || right < tar_left) return 0;

        if(left >= tar_left && right<= tar_right ){
            return tree[curr];
        }

        int mid = (left+right)/2;
        int ans = 0;

        

        return search(2*curr+1, left, mid, tar_left, tar_right, tree) + search(2*curr+2, mid+1, right, tar_left, tar_right, tree);


    }

    

    public void make_tree(int curr, int left, int right, int[]arr, int[]nums){
        if(left == right){
            arr[curr] = nums[left];
            return ;
        }

        int mid = (left+right)/2;
        make_tree(2*curr + 1, left, mid, arr, nums);
        make_tree(2*curr + 2, mid+1, right, arr, nums);

        arr[curr] = arr[2*curr + 1] + arr[2*curr+2];

    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */