class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> st = new HashSet<>();
        for(int i : arr){
            if(st.contains(i*2)) return true;
            if(i%2==0 && st.contains(i/2)) return true;

            if(st.contains(i)==false) st.add(i);
        }

        return false;
    }
}