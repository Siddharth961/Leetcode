class Solution {
    public int maxOperations(String s) {
        int ans = 0;
        int count = 0;

        char[]arr = s.toCharArray();

        for(int i=0; i<arr.length; i++){
            if(arr[i]=='1') count++;
            if(i-1>=0 && arr[i]=='0' && arr[i-1]=='1') ans += count;
        }

        return ans;
    }
}