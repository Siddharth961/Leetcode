class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();

        for(int i : nums1){
            if(mp.containsKey(i)) mp.put(i, mp.get(i)+1);
            else mp.put(i,1);
        }

        for(int i : nums2){
            if(mp.containsKey(i)){
                al.add(i);
                mp.put(i,mp.get(i)-1);
                if(mp.get(i)==0) mp.remove(i);
            }
            
        }
        int[]ans  = new int[al.size()];
        int i=0;
        for(var e : al){
            ans[i]  = e;
            i++;
        }

        return ans;
        
    }
}