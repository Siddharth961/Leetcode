class Solution {
    public boolean isFascinating(int n) {
        int[]arr = new int[3];
        arr[0] = n;
        arr[1] = 2*n;
        arr[2] = 3*n;

        HashSet<Integer> st  = new HashSet<>();

        int i = 0;
        while(i<3){

            if(arr[i]%10==0) return false;

            if(st.contains(arr[i]%10)) return false;
            else{
                st.add(arr[i]%10);
                arr[i] = arr[i]/10;
            }

            if(arr[i]==0) i++;

        }

        if(st.size()<9) return false;


        return true;
    }
}