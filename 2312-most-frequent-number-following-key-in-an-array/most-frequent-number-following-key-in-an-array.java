class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==key){
                mp.put(nums[i+1] , mp.getOrDefault(nums[i+1],0)+1);
            }
        }

        int ans = 0, max = 0;

        for(int i : mp.keySet()){
            if(max<mp.get(i)){
                max = mp.get(i);
                ans = i;
            }
        }

        return ans;
    }
}