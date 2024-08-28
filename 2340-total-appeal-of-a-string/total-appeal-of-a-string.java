class Solution {
    public long appealSum(String s) {
        char[]arr = s.toCharArray();
        int[]loc = new int[26];
        Arrays.fill(loc, -1);

        long ans = 0;

        
        for(int i=0; i<arr.length; i++){
            loc[arr[i]-'a'] = i;
            for(int j=0; j<26; j++){
                ans += loc[j] + 1;
            }
        }
        

        return ans;
    }
}