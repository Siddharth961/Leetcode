class Solution {
    public int minimumDeletions(String s) {
        char[]arr = s.toCharArray();
        
        int[]pre_b = new int[arr.length];
        int[]suf_a = new int[arr.length];

        int prefix = 0;

        for(int i=0; i<arr.length; i++){
            pre_b[i] = prefix;
            prefix += arr[i] - 'a';
        }

        prefix = 0;

        for(int i=arr.length-1; i>=0; i--){
            suf_a[i] = prefix;
            if(arr[i]=='a') prefix ++;
        }

        int min = arr.length;
        for(int i=0; i<arr.length; i++){
            min = Math.min(pre_b[i]+suf_a[i], min);
        }

        return min;
    }
}