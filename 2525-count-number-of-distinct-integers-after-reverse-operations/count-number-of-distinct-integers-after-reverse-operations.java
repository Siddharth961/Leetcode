class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int x = 0;
        for(int i : nums){
            st.add(i);
            if(i<=9) continue;
            x=0;
            while(i!=0){
                x = x*10 + i%10;
                i = i/10;
            }
            st.add(x);
        }

        return st.size();
    }
}