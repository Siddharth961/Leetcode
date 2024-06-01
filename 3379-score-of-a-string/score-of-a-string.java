class Solution {
    public int scoreOfString(String s) {

        int ans = 0;
        char[]arr = s.toCharArray();

        for(int i=1; i<arr.length; i++){
            ans += Math.abs( (int)(arr[i-1] - arr[i]) );

        }

        return ans;
        
    }
}