class FindSumPairs {
    HashMap<Integer, Integer>mp1 = new HashMap<>();
    HashMap<Integer, Integer>mp2 = new HashMap<>();

    int[]nums1;
    int[]nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {

        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int i: nums1) mp1.put(i, mp1.getOrDefault(i, 0) + 1);
        for(int i: nums2) mp2.put(i, mp2.getOrDefault(i, 0) + 1);
    }
    
    public void add(int index, int val) {
        int prev = nums2[index];

        nums2[index] += val;

        int curr = nums2[index];

        mp2.put(prev, mp2.get(prev) - 1); 
        mp2.put(curr, mp2.getOrDefault(curr, 0) + 1); 
    }
    
    public int count(int tot) {
        int ans = 0;

        // for(int i: nums1){
        //     int val = tot - i;
        //     ans += mp2.getOrDefault(val, 0);
        // }

        for( var e : mp1.keySet()){

            int val = tot - e;

            ans += ( mp1.get(e) * mp2.getOrDefault(val, 0) );

        }

        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */