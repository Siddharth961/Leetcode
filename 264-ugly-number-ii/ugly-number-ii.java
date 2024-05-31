class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> st = new TreeSet<>();

        int count = 0;
        st.add((long)1);
        long ans = 0;


        while(count<n){

            ans = st.pollFirst();
            count++;
            
            st.add( ans * 2);
            st.add( ans * 3);
            st.add( ans * 5);
        }

        // System.out.println(st);

        return (int)ans;
    }
}