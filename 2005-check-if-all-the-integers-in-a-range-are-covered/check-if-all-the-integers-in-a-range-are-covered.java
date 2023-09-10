class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        HashSet<Integer> st = new HashSet<>();

        for(int[] arr : ranges){
            for(int i=arr[0]; i<=arr[1]; i++) st.add(i);
        }

        for(int i=left; i<=right; i++) if(!st.contains(i)) return false;

        return true;
    }
}