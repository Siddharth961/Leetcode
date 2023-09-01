class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int max = 0;
        for(int i : nums){
            if(mp.containsKey(i)) mp.put(i, mp.get(i)+1);
            else mp.put(i,1);

            if(max<mp.get(i)) max = mp.get(i);
        }

        int ans=nums.length;

        for(var e : mp.entrySet()){
            if(e.getValue()==max){
                int a = len(e.getKey(),nums);
                if(ans>a) ans=a;
            }
        }

        return ans;

        
    }

    public int len(int a,int[]nums){
            int i=0;
            int j=nums.length-1;

            while(true){
                if(nums[i]==a && nums[j]==a) break;
                if(nums[i]!=a) i++;
                if(nums[j]!=a) j--;
            }

            return j-i+1;
        
        }

    
}