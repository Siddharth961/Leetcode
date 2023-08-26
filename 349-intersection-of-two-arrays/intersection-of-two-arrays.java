class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> mp = new HashSet<>();
        HashSet<Integer> st = new HashSet<>();

        for(int i : nums1) mp.add(i);
        for(int i : nums2){
            if(mp.contains(i)) st.add(i);
        }
        
        int[]ans = new int[st.size()];
        int i = 0;
        for(int j: st){
            ans[i] = j;
            i++;
            
        }

        return ans;
    } 
}