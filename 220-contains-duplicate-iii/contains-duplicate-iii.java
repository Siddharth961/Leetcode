class Solution {

    public long getId(long val, long w){

        return val > 0 ? val/w : val/w - 1;

    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        if(valueDiff < 0) return false;
        
        long divider = valueDiff + 1;
        
        HashMap<Long, Long> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){

            long id = getId( nums[i], divider);

            if(mp.containsKey(id)){
                return true;
            }
            else if(mp.containsKey(id+1) && Math.abs(nums[i] - mp.get(id+1)) <= valueDiff) return true;


            else if(mp.containsKey(id-1) && Math.abs(nums[i] - mp.get(id-1) )<= valueDiff) return true;

            mp.put(id , (long)nums[i]);

            if(i>=indexDiff) mp.remove( getId(nums[i-indexDiff] , divider ) );
        }

        return false;
    }
}