class KthLargest {

    int k = 0;
    int[]arr;
    int size = 0;


    public KthLargest(int k, int[] nums) {
        size = nums.length;
        Arrays.sort(nums);
        arr = new int[k];
        int j=k-1;
        for(int i=nums.length-1; i>=0 && i>=nums.length-k; i-- ) arr[j--] = nums[i];
        this.k = k;
    }
    
    public int add(int val) {
        if(size==k-1){
            arr[0] = val;
            Arrays.sort(arr);
            size++;
            return arr[0];
            
        }
        for(int i=arr.length-1; i>=arr.length-k; i--){
            if(val>arr[i]){
                int temp = arr[i];
                arr[i] = val;
                int ntemp = 0;
                for(int j=i-1; j>=arr.length-k; j--){
                    ntemp = arr[j];
                    arr[j] = temp;
                    temp = ntemp;
                }

                break;
            }
        }

        return arr[arr.length-k];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */