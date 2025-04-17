class Solution {
    public int countPairs(int[] nums, int k) {
        
        LinkedList<Integer>[]freq = new LinkedList[101];
        for(int i=0; i<101; i++) freq[i] = new LinkedList<>();

        int ans = 0;

        for(int i=0; i<nums.length; i++){

            int val = nums[i];

            if( i % k == 0) ans += freq[val].size();
            else{
                for(int j : freq[val]) if( (i*j) % k == 0) ans++;
            }

            freq[val].add(i);
        }

        return ans;
    }
}