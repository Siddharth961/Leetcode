class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> st = new HashSet<>();

        for(int i : arr){
            if(st.contains(i*2) || (i%2 == 0 && st.contains(i/2))) return true;
            st.add(i);
        }

        return false;
    }
}