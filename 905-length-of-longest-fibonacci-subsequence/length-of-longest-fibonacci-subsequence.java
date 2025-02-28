class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int ans =  get_ans(0, 0, 0, 0, arr);

        return ans <= 2 ? 0 : ans;
    }

    public int get_ans(int idx, int a, int b, int len, int[]arr){
        if(idx == arr.length){
            return len;
        }
            // System.out.println("idx: "+idx+" a: " +a+" b: " + b + " len: " + len);

        int ans = len;

        for(int i=idx; i<arr.length; i++){

            if(len < 2){
                // a = b;
                // b = arr[i];
                ans = Math.max(ans, get_ans(i+1, b, arr[i], len+1, arr) ); 
            }
            else{
                if(arr[i] == a+b ){
                    // a = b;
                    // b = arr[i];
                    ans = Math.max(ans, get_ans(i+1, b, arr[i], len+1, arr) );
                }
                else if( arr[i] > a+b ) break;
            }
        }

        return ans;
    }
}