class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> st = new HashSet<>();

        for(int i : nums){
            st.add(i);
            int x=0;
            while(i!=0){
                x = x*10 + i%10;
                i = i/10;
            }
            System.out.println(x);
            st.add(x);
        }

        return st.size();
    }
}