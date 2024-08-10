class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int idx = 0;
        int i = 0;
        char[]arr = s.toCharArray();

        int[]result ;
        while(i < arr.length){

            result = check(i, i, arr);

            if(max < result[1]){
                max = result[1];
                idx = result[0];
            }

            result = check(i, i+1, arr);

            if(max < result[1]){
                max = result[1];
                idx = result[0];
            }

            i++;

        }

        return s.substring(idx, idx+max);
    }

    public int[] check(int i, int j, char[]arr){

        

        int[]ans = new int[2];

        while( i>=0 && j<arr.length){
            if(arr[i] == arr[j]){
                ans[0] = i;
                ans[1] = j-i+1;
                i--;
                j++;
            }
            else return ans;
        }

        return ans;
    }
}