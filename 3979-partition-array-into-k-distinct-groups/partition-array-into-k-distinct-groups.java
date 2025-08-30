class Solution {
    public boolean partitionArray(int[] nums, int k) {

        if(nums.length % k != 0) return false;
        
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i : nums){
            mp.put( i, mp.getOrDefault(i, 0) + 1);
        }

        int groups_needed = nums.length/k;

       
        for( var e : mp.keySet() ){
            int val = mp.get(e);
            
            if( val > groups_needed ) return false;
        }

        return true;


    }
}