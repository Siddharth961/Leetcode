class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        int max = 0;
        for(int i : nums){
            al.add(i);
            if(mp.containsKey(i)) mp.put(i, mp.get(i)+1);
            else mp.put(i,1);

            if(max<mp.get(i)) max = mp.get(i);
        }

        int ans=nums.length;

        for(var e : mp.entrySet()){
            if(e.getValue()==max){
                int a = al.indexOf(e.getKey());
                int b = al.lastIndexOf(e.getKey());
                if(ans>(b-a+1)) ans=b-a+1;
            }
        }

        return ans;

        
    }

    
}