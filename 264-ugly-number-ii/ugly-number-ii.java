class Solution {
    public int nthUglyNumber(int n) {
        
        int[]arr = new int[n];
        arr[0] = 1;

        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;

        

        for(int i=1; i<n; i++){
            arr[i] = Math.min( arr[idx2]*2, Math.min(arr[idx3]*3, arr[idx5]*5) );

            if(arr[i] == arr[idx2]*2 ) idx2++; 
            if(arr[i] == arr[idx3]*3 ) idx3++; 
            if(arr[i] == arr[idx5]*5 ) idx5++; 
        }

        return arr[n-1];
    }
}