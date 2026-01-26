class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min_val = Integer.MAX_VALUE;

        for(int i=1; i<arr.length; i++){
            min_val = Math.min(min_val, Math.abs(arr[i] - arr[i-1] ));
        }

        List<List<Integer>> ans = new LinkedList<>();

        for(int i=1; i<arr.length; i++){
            if(Math.abs(arr[i]-arr[i-1]) == min_val){
                List<Integer> ll = new LinkedList<>();
                ll.add(arr[i-1]);
                ll.add(arr[i]);

                ans.add(ll);
            }
        }

        return ans;

    }
}