class Solution {
    public int minimumDeletions(String s) {

        int n = s.length();
        
        int[]pre_a = new int[n];
        int[]suf_b = new int[n];

        for(int i=0; i<n; i++){

            if(i > 0) pre_a[i] = pre_a[i-1];

            if(s.charAt(i)=='a')pre_a[i]++;
        }

        for(int i=n-1; i>=0; i--){

            if(i < n-1) suf_b[i] = suf_b[i+1];

            if(s.charAt(i)=='b')suf_b[i]++;
        }

        int val = 0;

        for(int i=0; i<n; i++){

            val = Math.max(val, pre_a[i] + suf_b[i]);
        }

        return n - val;
    }
}