class Solution {

    int[]nums;
    private Random rand;

    int size = 0;

    public Solution(int[] w) {

        this.rand = new Random();
        
        

        for (int i = 1; i < w.length; i++) {
           w[i] += w[i - 1];
       }

        size = w[ w.length - 1];
        nums = w;
    }

    public int search(int tar){

        // System.out.println(tar);
        int l = 0;
        int h = nums.length - 1;
        int mid = 0;

        while(l < h){

            mid = l + (h - l)/2;

            if(nums[mid] == tar) return mid;

            if( nums[mid] < tar){
                l = mid+1;
            }
            else h = mid;

        }

        return l;
    }
    
    public int pickIndex() {
        int n = this.rand.nextInt(size) + 1;

        return search(n);
    }
}

// 0 3 8 15 24

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */