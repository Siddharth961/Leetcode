class Solution {
    public String smallestPalindrome(String s) {
        
        int mid = s.length() / 2  ;

        char[]arr = s.toCharArray();

        Arrays.sort(arr, 0, mid);

        int i=0;
        int j=arr.length-1;

        while(i < j){
            arr[j] = arr[i];

            j--;
            i++;
        }

        return  new String(arr);
    }
}