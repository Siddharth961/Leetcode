class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int i : nums) st.add(i);
        int len=0,curr=0;
        for(int i : st){
            if(st.contains(i-1)) continue;

            curr = 1;
            while(st.contains(i+1)){
                curr ++;
                i++;
            }

            if(len<curr) len = curr;
        }

        return len;
    }
}