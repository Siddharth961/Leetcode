class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {

        char[]str_arr = s.toCharArray();
        
        int[]pre = get_prefix_plates(str_arr);
        int[]left_cand = get_cand_left(str_arr);
        int[]right_cand = get_cand_right(str_arr);

        int[]ans = new int[queries.length];

        int idx=0;

        for(int[]q : queries){

            int l = right_cand[ q[0] ]; // first candle that appears in range
            int r = left_cand[ q[1] ]; // last candle that appears in range

            // now all plates in this range are valid..can be calculated using prefix;

            if(l < r)ans[idx] = pre[r] - ( l > 0 ? pre[l-1] : 0);
            idx++;
        }

        return ans;
    }

    public int[] get_prefix_plates(char[]arr){
        
        int[]pre = new int[arr.length];

        for(int i=0; i<arr.length; i++){

            if(arr[i] == '*') pre[i]++;

            if(i > 0) pre[i] += pre[i-1];

        }

        return pre;
    }

    public int[] get_cand_left(char[]arr){

        int[]ans = new int[arr.length];

        int last_cand = -1;

        for(int i=0; i<ans.length; i++){

            if(arr[i] == '|') last_cand = i;
            
            ans[i] = last_cand;
        }

        return ans;
    }


    public int[] get_cand_right(char[]arr){

        int[]ans = new int[arr.length];

        int last_cand = arr.length;

        for(int i=arr.length-1; i>=0; i--){

            if(arr[i] == '|') last_cand = i;
            
            ans[i] = last_cand;
        }

        return ans;
    }
}