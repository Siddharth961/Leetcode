class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> mp = new HashMap<>();

        int ans = 0;
        String s;

        for(int[]arr : dominoes){
            s = arr[0]+" "+arr[1];
            
            ans += mp.getOrDefault(s , 0);
            mp.put(s, mp.getOrDefault(s, 0) + 1);

            if(arr[0] != arr[1]){
                s = arr[1] + " "+arr[0];
                ans += mp.getOrDefault(s, 0);
            }

            // System.out.println(ans+"--"+mp);
        }

        return ans;
    }
}