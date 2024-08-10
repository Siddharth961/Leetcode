class Solution {
    public boolean validPalindrome(String s) {

        char[]arr = s.toCharArray();
        
        int i=0;
        int j=arr.length-1;

        while( i <= j){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }

            else{
                return check( arr, i+1, j) || check(arr, i, j-1);
            }
        }

        return true;
    }

    public boolean check(char[]arr, int i, int j){

        while( i<=j ){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }

            else return false;
        }
        return true;
    }
}