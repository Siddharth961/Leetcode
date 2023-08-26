class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i : nums1) mp.put(i,1);
        for(int i : nums2){
            if(mp.containsKey(i)) mp.put(i,2);
        }
        int count=0;
        for(var e : mp.entrySet()){
            if(e.getValue()==2)  count++;
        }

        int[]ans = new int[count];
        int i = 0;
        for(var e : mp.entrySet()){
            if(e.getValue()==2){
                ans[i] = e.getKey();
                i++;
            } 
        }

        return ans;
    } 
}