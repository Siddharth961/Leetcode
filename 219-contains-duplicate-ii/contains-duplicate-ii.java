class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(nums[i])==false){
                mp.put(nums[i],i);

            }

            else{
                if(i-mp.get(nums[i])<=k) return true;
                else if(k<nums.length/2 ) mp.put(nums[i],i);
                
            }
        }

        return false;
    }
}