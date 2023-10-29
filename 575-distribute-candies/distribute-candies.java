class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> st = new HashSet<>();
        for(int i : candyType){
            st.add(i);
            if(st.size()== candyType.length/2) break;
        }
        if( (candyType.length/2) <= st.size() ) return candyType.length/2;
        else return st.size();
    }
}