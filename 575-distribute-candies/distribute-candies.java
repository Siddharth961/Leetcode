class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> st = new HashSet<>();
        for(int i : candyType){
            st.add(i);
            if(st.size()== candyType.length/2) break;
        }
        return st.size();
    }
}