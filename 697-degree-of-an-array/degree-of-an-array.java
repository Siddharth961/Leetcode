class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,int[]> mp = new HashMap<>();
        int max = 0;
        for(int i=0; i<nums.length; i++){
      
            if(mp.containsKey(nums[i])){
                int[]arr = mp.get(nums[i]);
                arr[1] = i;
                arr[2]++;
                mp.put(nums[i], arr);
            }
            else{
                int[]arr = new int[]{i,i,1};
                mp.put(nums[i],arr);
            }

            if(max<mp.get(nums[i])[2]) max = mp.get(nums[i])[2];
        }

        int ans=nums.length;

        for(var e : mp.values()){
            if(e[2]==max){                               
                if(ans>(e[1]-e[0]+1)) ans=e[1]-e[0]+1;
            }
        }

        return ans;

        
    }

    
}