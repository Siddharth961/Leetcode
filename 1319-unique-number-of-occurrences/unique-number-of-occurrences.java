class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        HashSet<Integer> st = new HashSet<>();

        for(int i: arr){
            if(mp.containsKey(i)) mp.put(i, mp.get(i)+1);
            else mp.put(i,1);
        }

        for(int i : mp.values()){
            if(st.contains(i)) return false;
            else st.add(i);
        }

        return true;
    }
}