class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> mp = new TreeMap<>();

        for(int i=0; i<names.length; i++){
            mp.put(heights[i],names[i]);
        }

        String[]ans = new String[names.length];
        int i = ans.length-1;

        for(var e : mp.values()){
            ans[i] = e;
            i--;

        }

        return ans;
    }
}